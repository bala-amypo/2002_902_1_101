package com.example.demo.service;

import com.example.demo.model.StockRecord;
import java.util.List;

public interface StockRecordService {

    StockRecord addStock(Long warehouseId, Long productId, StockRecord stockRecord);

    StockRecord getById(Long id);

    List<StockRecord> getByWarehouse(Long warehouseId);

    List<StockRecord> getByProduct(Long productId);
}
