package com.example.demo.service.impl;

import com.example.demo.service.PredictionService;
import org.springframework.stereotype.Service;

@Service
public class PredictionServiceImpl implements PredictionService {

    @Override
    public int predictRestock(Long productId) {
        // Dummy implementation
        return 100; // Example fixed prediction
    }
}
