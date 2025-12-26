package com.example.demo.service.impl;

import com.example.demo.model.StockRecord;
import com.example.demo.repository.StockRecordRepository;
import com.example.demo.service.StockRecordService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockRecordServiceImpl implements StockRecordService {

    private final StockRecordRepository repository;

    public StockRecordServiceImpl(StockRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<StockRecord> getStockRecordsByProductId(Long productId) {
        return repository.findByProductId(productId);
    }

    @Override
    public List<StockRecord> getStockRecordsByWarehouseId(Long warehouseId) {
        return repository.findByWarehouseId(warehouseId);
    }

    @Override
    public StockRecord createStockRecord(StockRecord stockRecord) {
        return repository.save(stockRecord);
    }
}
