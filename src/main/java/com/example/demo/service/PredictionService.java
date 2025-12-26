package com.example.demo.service;

import com.example.demo.model.PredictionRule;
import com.example.demo.repository.PredictionRuleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PredictionService {

    private final PredictionRuleRepository predictionRuleRepository;

    public PredictionRuleService(PredictionRuleRepository predictionRuleRepository) {
        this.predictionRuleRepository = predictionRuleRepository;
    }

    public List<PredictionRule> getAllRules() {
        return predictionRuleRepository.findAll();
    }

    public PredictionRule createRule(PredictionRule rule) {
        return predictionRuleRepository.save(rule);
    }
}
