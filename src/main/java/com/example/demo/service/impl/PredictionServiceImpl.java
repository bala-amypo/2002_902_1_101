package com.example.demo.service.impl;

import com.example.demo.service.PredictionService;
import org.springframework.stereotype.Service;

@Service   // ⭐ THIS IS THE MOST IMPORTANT LINE
public class PredictionServiceImpl implements PredictionService {

    @Override
    public String predictRestock(Long productId) {
        // Dummy logic for now
        return "Restock recommended for product id: " + productId;
    }
}
