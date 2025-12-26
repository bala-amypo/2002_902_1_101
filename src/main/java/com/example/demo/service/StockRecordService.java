package com.example.demo.service;

import com.example.demo.model.StockRecord;
import com.example.demo.repository.StockRecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockRecordService {

    private final StockRecordRepository stockRecordRepository;

    public StockRecordService(StockRecordRepository stockRecordRepository) {
        this.stockRecordRepository = stockRecordRepository;
    }

    public List<StockRecord> getStockRecordsByProductId(Long productId) {
        return stockRecordRepository.findByProductId(productId);
    }

    public List<StockRecord> getStockRecordsByWarehouseId(Long warehouseId) {
        return stockRecordRepository.findByWarehouseId(warehouseId);
    }

    public StockRecord createStockRecord(StockRecord stockRecord) {
        return stockRecordRepository.save(stockRecord);
    }
}
