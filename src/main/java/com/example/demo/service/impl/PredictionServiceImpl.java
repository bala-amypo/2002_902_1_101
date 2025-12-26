package com.example.demo.service.impl;

import com.example.demo.model.PredictionRule;
import com.example.demo.repository.PredictionRuleRepository;
import com.example.demo.service.PredictionRuleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PredictionServiceImpl implements PredictionService {

    private final PredictionRuleRepository predictionRuleRepository;

    public PredictionServiceImpl(PredictionRuleRepository predictionRuleRepository) {
        this.predictionRuleRepository = predictionRuleRepository;
    }

    @Override
    public List<PredictionRule> getAllRules() {
        return predictionRuleRepository.findAll();
    }

    @Override
    public PredictionRule createRule(PredictionRule rule) {
        return predictionRuleRepository.save(rule);
    }
}
