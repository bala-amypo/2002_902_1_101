package com.example.demo.controller;

import com.example.demo.service.PredictionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prediction")
public class PredictionController {

    private final PredictionService predictionService;

    public PredictionController(PredictionService predictionService) {
        this.predictionService = predictionService;
    }

    @GetMapping("/{productId}")
    public String predict(@PathVariable Long productId) {
        return predictionService.predictRestock(productId);
    }
}
