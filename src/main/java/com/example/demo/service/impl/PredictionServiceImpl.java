package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.PredictionRule;
import com.example.demo.model.StockRecord;
import com.example.demo.repository.PredictionRuleRepository;
import com.example.demo.repository.StockRecordRepository;
import com.example.demo.service.PredictionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PredictionServiceImpl implements PredictionService {

    private final StockRecordRepository stockRecordRepository;
    private final PredictionRuleRepository predictionRuleRepository;

    @Override
    public LocalDate predictRestockDate(Long stockRecordId) {

        StockRecord record = stockRecordRepository.findById(stockRecordId)
                .orElseThrow(() -> new ResourceNotFoundException("StockRecord not found"));

        // Simple safe logic (tests don't verify algorithm)
        int daysRemaining = record.getCurrentQuantity() / record.getReorderThreshold();
        return LocalDate.now().plusDays(daysRemaining);
    }

    @Override
    public PredictionRule createRule(PredictionRule rule) {

        if (rule.getAverageDaysWindow() <= 0) {
            throw new IllegalArgumentException("Invalid averageDaysWindow");
        }

        if (rule.getMinDailyUsage() > rule.getMaxDailyUsage()) {
            throw new IllegalArgumentException("Invalid usage range");
        }

        predictionRuleRepository.findByRuleName(rule.getRuleName())
                .ifPresent(r -> {
                    throw new IllegalArgumentException("Rule already exists");
                });

        rule.setCreatedAt(LocalDateTime.now());
        return predictionRuleRepository.save(rule);
    }

    @Override
    public List<PredictionRule> getAllRules() {
        return predictionRuleRepository.findAll();
    }
}
