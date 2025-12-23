package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.PredictionRule;
import com.example.demo.service.PredictionService;

@RestController
@RequestMapping("/predict")
public class PredictionRuleController {

    @Autowired
    private PredictionService predictionService;

    @GetMapping("/restock-date/{stockRecordId}")
    public LocalDate predictRestockDate(@PathVariable Long stockRecordId) {
        return predictionService.predictRestockDate(stockRecordId);
    }

    @PostMapping("/rules")
    public PredictionRule createRule(@RequestBody PredictionRule rule) {
        return predictionService.createRule(rule);
    }

    @GetMapping("/rules")
    public List<PredictionRule> getAllRules() {
        return predictionService.getAllRules();
    }
}
