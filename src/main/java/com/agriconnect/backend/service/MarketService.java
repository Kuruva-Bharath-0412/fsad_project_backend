package com.agriconnect.backend.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MarketService {

    public String getMarketPrices() {
        try {
            RestTemplate restTemplate = new RestTemplate();

            String url = "https://api.data.gov.in/resource/9ef84268-d588-465a-a308-a864a43d0070?api-key=YOUR_REAL_API_KEY&format=json&limit=10";

            return restTemplate.getForObject(url, String.class);

        } catch (Exception e) {
            return "{\"records\":[]}";
        }
    }
}