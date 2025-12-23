package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.StockRecord;
import com.example.demo.service.StockRecordService;

@RestController
@RequestMapping("/stock-records")
public class StockRecordController {

    @Autowired
    private StockRecordService stockRecordService;

    @PostMapping
    public StockRecord create(@RequestBody StockRecord record) {
        return stockRecordService.create(record);
    }

    @GetMapping
    public List<StockRecord> getAll() {
        return stockRecordService.getAll();
    }

    @GetMapping("/{id}")
    public StockRecord getById(@PathVariable Long id) {
        return stockRecordService.getById(id);
    }
}
