package com.example.demo.service;

import java.util.List;
import com.example.demo.model.PredictionRule;

public interface PredictionRuleService {

    PredictionRule create(PredictionRule rule);

    List<PredictionRule> getAll();

    PredictionRule getById(Long id);
}
