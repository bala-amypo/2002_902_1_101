package com.example.demo.controller;

import com.example.demo.model.PredictionRule;
import com.example.demo.service.PredictionRuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/predictions")
public class PredictionRuleController {

    private final PredictionRuleService predictionRuleService;

    public PredictionRuleController(PredictionRuleService predictionRuleService) {
        this.predictionRuleService = predictionRuleService;
    }

    @GetMapping
    public ResponseEntity<List<PredictionRule>> getAllRules() {
        return ResponseEntity.ok(predictionRuleService.getAllRules());
    }

    @PostMapping
    public ResponseEntity<PredictionRule> createRule(@RequestBody PredictionRule rule) {
        return ResponseEntity.ok(predictionRuleService.createRule(rule));
    }
}
