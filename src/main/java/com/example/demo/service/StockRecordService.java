package com.example.demo.service;

import java.util.List;
import com.example.demo.model.StockRecord;

public interface StockRecordService {

    StockRecord create(StockRecord record);

    List<StockRecord> getAll();

    StockRecord getById(Long id);
}
