package com.example.demo.service;

import com.example.demo.model.PredictionRule;
import java.time.LocalDate;
import java.util.List;

public interface PredictionService {

    String predictRestock(Long productId, LocalDate date);

    PredictionRule saveRule(PredictionRule rule);

    List<PredictionRule> getAllRules();
}
