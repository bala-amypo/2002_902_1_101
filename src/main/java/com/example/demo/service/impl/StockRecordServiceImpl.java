package com.example.demo.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.StockRecord;
import com.example.demo.repository.StockRecordRepository;
import com.example.demo.service.StockRecordService;

@Service
public class StockRecordServiceImpl implements StockRecordService {

    @Autowired
    private StockRecordRepository stockRecordRepository;

    @Override
    public StockRecord create(StockRecord record) {
        record.setLastUpdated(LocalDateTime.now());
        return stockRecordRepository.save(record);
    }

    @Override
    public List<StockRecord> getAll() {
        return stockRecordRepository.findAll();
    }

    @Override
    public StockRecord getById(Long id) {
        return stockRecordRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("StockRecord not found"));
    }
}
