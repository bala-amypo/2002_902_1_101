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
    public StockRecord addStock(Long warehouseId, Long productId, StockRecord record) {
        record.setProductId(productId);
        record.setWarehouseId(warehouseId); // make sure StockRecord has warehouseId
        return stockRecordRepository.save(record);
    }

    @Override
    public StockRecord getById(Long id) {
        return stockRecordRepository.findById(id).orElse(null);
    }

    @Override
    public List<StockRecord> getByProduct(Long productId) {
        return stockRecordRepository.findByProductId(productId);
    }

    @Override
    public List<StockRecord> getByWarehouse(Long warehouseId) {
        return stockRecordRepository.findByWarehouseId(warehouseId);
    }
}
