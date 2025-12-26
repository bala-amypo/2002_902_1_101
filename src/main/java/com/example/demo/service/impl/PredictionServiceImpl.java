package com.example.demo.service.impl;

import com.example.demo.model.StockRecord;
import com.example.demo.repository.StockRecordRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PredictionServiceImpl {

    private final StockRecordRepository stockRecordRepository;

    public PredictionServiceImpl(StockRecordRepository stockRecordRepository) {
        this.stockRecordRepository = stockRecordRepository;
    }

    public int getReorderQuantity(Long productId) {
        List<StockRecord> records = stockRecordRepository.findByProductId(productId);
        int total = 0;
        for (StockRecord record : records) {
            total += Math.max(0, record.getReorderLevel() - record.getQuantity());
        }
        return total;
    }
}
