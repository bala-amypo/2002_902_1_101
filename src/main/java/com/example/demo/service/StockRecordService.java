package com.example.demo.service;

import com.example.demo.model.StockRecord;
import java.util.List;

public interface StockRecordService {
    StockRecord addStock(Long productId, Long warehouseId, StockRecord record);
    StockRecord getById(Long id);
    List<StockRecord> getByWarehouse(Long warehouseId);
    List<StockRecord> getByProduct(Long productId);
}
