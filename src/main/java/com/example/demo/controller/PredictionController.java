package com.example.demo.controller;

import com.example.demo.model.PredictionRule;
import com.example.demo.service.PredictionService;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/predictions")
public class PredictionController {

    private final PredictionService predictionService;

    public PredictionController(PredictionService predictionService) {
        this.predictionService = predictionService;
    }

    @GetMapping("/{productId}")
    public String predict(
            @PathVariable Long productId,
            @RequestParam LocalDate date) {
        return predictionService.predictRestock(productId, date);
    }

    @PostMapping
    public PredictionRule saveRule(@RequestBody PredictionRule rule) {
        return predictionService.saveRule(rule);
    }

    @GetMapping
    public List<PredictionRule> getAllRules() {
        return predictionService.getAllRules();
    }
}
