package com.example.demo.service;

import com.example.demo.model.StockRecord;
import java.util.List;

public interface StockRecordService {

    List<StockRecord> getStockRecordsByProductId(Long productId);

    List<StockRecord> getStockRecordsByWarehouseId(Long warehouseId);

    StockRecord createStockRecord(StockRecord stockRecord);
}
