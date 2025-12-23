package com.example.demo.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.PredictionRule;
import com.example.demo.model.StockRecord;
import com.example.demo.repository.PredictionRuleRepository;
import com.example.demo.repository.StockRecordRepository;
import com.example.demo.service.PredictionService;

@Service
public class PredictionServiceImpl implements PredictionService {

    @Autowired
    private PredictionRuleRepository predictionRuleRepository;

    @Autowired
    private StockRecordRepository stockRecordRepository;

    @Override
    public LocalDate predictRestockDate(Long stockRecordId) {
        StockRecord record = stockRecordRepository
                .findById(stockRecordId)
                .orElseThrow(() -> new RuntimeException("StockRecord not found"));

        return record.getCurrentQuantity() <= record.getReorderThreshold()
                ? LocalDate.now().plusDays(3)
                : LocalDate.now().plusDays(10);
    }

    @Override
    public PredictionRule createRule(PredictionRule rule) {
        return predictionRuleRepository.save(rule);
    }

    @Override
    public List<PredictionRule> getAllRules() {
        return predictionRuleRepository.findAll();
    }
}
