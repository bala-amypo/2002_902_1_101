package com.example.demo.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.PredictionRule;
import com.example.demo.repository.PredictionRuleRepository;
import com.example.demo.service.PredictionRuleService;

@Service
public class PredictionRuleServiceImpl implements PredictionRuleService {

    @Autowired
    private PredictionRuleRepository predictionRuleRepository;

    @Override
    public PredictionRule create(PredictionRule rule) {
        rule.setCreatedAt(LocalDateTime.now());
        return predictionRuleRepository.save(rule);
    }

    @Override
    public List<PredictionRule> getAll() {
        return predictionRuleRepository.findAll();
    }

    @Override
    public PredictionRule getById(Long id) {
        return predictionRuleRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("PredictionRule not found"));
    }
}
