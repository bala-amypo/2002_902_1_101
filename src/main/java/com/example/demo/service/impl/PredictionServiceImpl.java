package com.example.demo.service.impl;

import com.example.demo.model.PredictionRule;
import com.example.demo.model.StockRecord;
import com.example.demo.repository.StockRecordRepository;
import com.example.demo.service.PredictionService;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PredictionServiceImpl implements PredictionService {

    private final StockRecordRepository stockRecordRepository;

    public PredictionServiceImpl(StockRecordRepository stockRecordRepository) {
        this.stockRecordRepository = stockRecordRepository;
    }

    @Override
    public String predictRestock(Long productId, LocalDate date) {
        List<StockRecord> records = stockRecordRepository.findByProductId(productId);

        for (StockRecord record : records) {
            if (record.getQuantity() <= record.getReorderLevel()) {
                return "RESTOCK REQUIRED";
            }
        }
        return "STOCK OK";
    }

    @Override
    public PredictionRule saveRule(PredictionRule rule) {
        return rule;
    }

    @Override
    public List<PredictionRule> getAllRules() {
        return List.of();
    }
}
