package com.example.demo.service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.ConsumptionLog;
import com.example.demo.model.PredictionRule;
import com.example.demo.model.StockRecord;
import com.example.demo.repository.ConsumptionLogRepository;
import com.example.demo.repository.PredictionRuleRepository;
import com.example.demo.repository.StockRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PredictionServiceImpl implements PredictionService {
    
    @Autowired
    private PredictionRuleRepository predictionRuleRepository;
    
    @Autowired
    private StockRecordRepository stockRecordRepository;
    
    @Autowired
    private ConsumptionLogRepository consumptionLogRepository;
    
    @Override
    public LocalDate predictRestockDate(Long stockRecordId) {
        StockRecord stockRecord = stockRecordRepository.findById(stockRecordId)
                .orElseThrow(() -> new ResourceNotFoundException("StockRecord not found"));
        
        List<ConsumptionLog> logs = consumptionLogRepository.findByStockRecordId(stockRecordId);
        
        if (logs.isEmpty()) {
            return LocalDate.now().plusDays(30); // Default if no consumption data
        }
        
        // Simple prediction: calculate average daily consumption over last 30 days
        LocalDate cutoffDate = LocalDate.now().minusDays(30);
        double totalConsumed = logs.stream()
                .filter(log -> log.getConsumedDate().isAfter(cutoffDate))
                .mapToInt(ConsumptionLog::getConsumedQuantity)
                .sum();
        
        double avgDailyConsumption = totalConsumed / 30.0;
        
        if (avgDailyConsumption <= 0) {
            return LocalDate.now().plusDays(365); // Very far future if no consumption
        }
        
        int daysUntilReorder = (int) Math.ceil(
                (stockRecord.getCurrentQuantity() - stockRecord.getReorderThreshold()) / avgDailyConsumption);
        
        return LocalDate.now().plusDays(Math.max(0, daysUntilReorder));
    }
    
    @Override
    public List<PredictionRule> getAllRules() {
        return predictionRuleRepository.findAll();
    }
    
    @Override
    public PredictionRule createRule(PredictionRule rule) {
        if (rule.getAverageDaysWindow() <= 0) {
            throw new IllegalArgumentException("Average days window must be greater than zero");
        }
        
        if (rule.getMinDailyUsage() > rule.getMaxDailyUsage()) {
            throw new IllegalArgumentException("Min daily usage must be less than or equal to max daily usage");
        }
        
        if (predictionRuleRepository.findByRuleName(rule.getRuleName()).isPresent()) {
            throw new IllegalArgumentException("Rule name must be unique");
        }
        
        rule.setCreatedAt(LocalDateTime.now());
        return predictionRuleRepository.save(rule);
    }
}