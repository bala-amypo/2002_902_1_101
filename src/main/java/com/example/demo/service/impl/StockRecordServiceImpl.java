package com.example.demo.service.impl;

import com.example.demo.model.StockRecord;
import com.example.demo.repository.StockRecordRepository;
import com.example.demo.service.StockRecordService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StockRecordServiceImpl implements StockRecordService {

    private final StockRecordRepository stockRecordRepository;

    public StockRecordServiceImpl(StockRecordRepository stockRecordRepository) {
        this.stockRecordRepository = stockRecordRepository;
    }

    @Override
    public StockRecord save(StockRecord record) {
        return stockRecordRepository.save(record);
    }

    @Override
    public List<StockRecord> getByProduct(Long productId) {
        return stockRecordRepository.findByProductId(productId);
    }
}
