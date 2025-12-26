package com.example.demo.controller;

import com.example.demo.model.StockRecord;
import com.example.demo.service.StockRecordService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stock-records")
public class StockRecordController {

    private final StockRecordService stockRecordService;

    public StockRecordController(StockRecordService stockRecordService) {
        this.stockRecordService = stockRecordService;
    }

    @PostMapping("/{warehouseId}/{productId}")
    public StockRecord addStock(
            @PathVariable Long warehouseId,
            @PathVariable Long productId,
            @RequestBody StockRecord stockRecord) {

        return stockRecordService.addStock(warehouseId, productId, stockRecord);
    }

    @GetMapping("/{id}")
    public StockRecord getById(@PathVariable Long id) {
        return stockRecordService.getById(id);
    }

    @GetMapping("/warehouse/{warehouseId}")
    public List<StockRecord> getByWarehouse(@PathVariable Long warehouseId) {
        return stockRecordService.getByWarehouse(warehouseId);
    }

    @GetMapping("/product/{productId}")
    public List<StockRecord> getByProduct(@PathVariable Long productId) {
        return stockRecordService.getByProduct(productId);
    }
}
