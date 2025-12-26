package com.example.demo.controller;

import com.example.demo.model.StockRecord;
import com.example.demo.service.StockRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stocks")
public class StockRecordController {

    private final StockRecordService stockRecordService;

    public StockRecordController(StockRecordService stockRecordService) {
        this.stockRecordService = stockRecordService;
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<StockRecord>> getStocksByProduct(@PathVariable Long productId) {
        return ResponseEntity.ok(stockRecordService.getStockRecordsByProductId(productId));
    }

    @GetMapping("/warehouse/{warehouseId}")
    public ResponseEntity<List<StockRecord>> getStocksByWarehouse(@PathVariable Long warehouseId) {
        return ResponseEntity.ok(stockRecordService.getStockRecordsByWarehouseId(warehouseId));
    }

    @PostMapping
    public ResponseEntity<StockRecord> createStockRecord(@RequestBody StockRecord stockRecord) {
        return ResponseEntity.ok(stockRecordService.createStockRecord(stockRecord));
    }
}
