package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;
import com.example.demo.model.PredictionRule;

public interface PredictionService {

    LocalDate predictRestockDate(Long stockRecordId);

    PredictionRule createRule(PredictionRule rule);

    List<PredictionRule> getAllRules();
}
