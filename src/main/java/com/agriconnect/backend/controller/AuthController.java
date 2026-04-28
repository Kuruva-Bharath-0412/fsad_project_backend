package com.agriconnect.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.agriconnect.backend.entity.User;
import com.agriconnect.backend.entity.Question;
import com.agriconnect.backend.entity.Crop;
import com.agriconnect.backend.repository.UserRepository;
import com.agriconnect.backend.repository.QuestionRepository;
import com.agriconnect.backend.repository.CropRepository;
import com.agriconnect.backend.service.MailService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private UserRepository repo;

    @Autowired
    private QuestionRepository questionRepo;

    @Autowired
    private CropRepository cropRepo;

    @Autowired
    private MailService mailService;

    // ================= REGISTER =================
    @PostMapping("/register")
    public String register(@RequestBody User user) {

        if (repo.findByEmail(user.getEmail()).isPresent()) {
            return "User already exists";
        }

        // ✅ PASSWORD VALIDATION
        String password = user.getPassword();
        String pattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&]).{8,}$";

        if (!password.matches(pattern)) {
            return "Password must be at least 8 characters and include uppercase, lowercase, number, and special character";
        }

        String otp = String.valueOf((int)(Math.random() * 900000) + 100000);

        user.setOtp(otp);
        user.setVerified(false);

        repo.save(user);
        mailService.sendOtp(user.getEmail(), otp);

        return "OTP sent to email";
    }

    // ================= VERIFY OTP =================
    @PostMapping("/verify")
    public String verify(@RequestBody User user) {

        User existing = repo.findByEmail(user.getEmail()).orElse(null);

        if (existing != null &&
            existing.getOtp() != null &&
            existing.getOtp().equals(user.getOtp())) {

            existing.setVerified(true);
            repo.save(existing);
            return "Account verified";
        }

        return "Invalid OTP";
    }

    // ================= LOGIN =================
    @PostMapping("/login")
    public String login(@RequestBody User user) {

        User existing = repo.findByEmail(user.getEmail()).orElse(null);

        if (existing == null ||
            !existing.getPassword().equals(user.getPassword())) {
            return "Invalid credentials";
        }

        if (!existing.isVerified()) {
            return "Please verify OTP first";
        }

        if (existing.getRole() == null ||
            !existing.getRole().equalsIgnoreCase(user.getRole())) {
            return "Role mismatch";
        }

        return "Login successful";
    }

    // ================= GET ALL EXPERTS =================
    @GetMapping("/experts")
    public List<User> getExperts() {
        return repo.findAll()
                .stream()
                .filter(u -> "EXPERT".equalsIgnoreCase(u.getRole()))
                .toList();
    }

    // ================= ASK QUESTION =================
    @PostMapping("/ask")
    public String askQuestion(@RequestBody Question q) {

        User farmer = repo.findByEmail(q.getFarmer().getEmail()).orElse(null);
        User expert = repo.findByEmail(q.getExpert().getEmail()).orElse(null);

        if (farmer == null || expert == null) {
            return "User not found";
        }

        q.setFarmer(farmer);
        q.setExpert(expert);

        questionRepo.save(q);

        return "Question sent";
    }

    // ================= EXPERT VIEW QUESTIONS =================
    @GetMapping("/expert-questions/{email}")
    public List<Question> getExpertQuestions(@PathVariable String email) {

        User expert = repo.findByEmail(email).orElse(null);

        if (expert == null) return List.of();

        return questionRepo.findByExpert(expert);
    }

    // ================= REPLY =================
    @PostMapping("/reply")
    public String reply(@RequestBody Question q) {

        Question existing = questionRepo.findById(q.getId()).orElse(null);

        if (existing != null) {
            existing.setAnswer(q.getAnswer());
            questionRepo.save(existing);
            return "Reply sent";
        }

        return "Question not found";
    }

    // ================= FARMER VIEW QUESTIONS =================
    @GetMapping("/farmer-questions/{email}")
    public List<Question> getFarmerQuestions(@PathVariable String email) {

        User farmer = repo.findByEmail(email).orElse(null);

        if (farmer == null) return List.of();

        return questionRepo.findByFarmer(farmer);
    }

    @PostMapping("/add-crop")
    public String addCrop(@RequestBody Crop crop) {

        if (crop.getFarmer() == null || crop.getFarmer().getEmail() == null) {
            return "Farmer email missing";
        }

        User farmer = repo.findByEmail(crop.getFarmer().getEmail()).orElse(null);

        if (farmer == null) {
            return "Farmer not found";
        }

        crop.setFarmer(farmer);
        cropRepo.save(crop);

        return "Crop added successfully";
    }
    // ================= GET ALL CROPS =================
    @GetMapping("/crops")
    public List<Crop> getAllCrops() {
        return cropRepo.findAll();
    }
}