package com.example.demo.controller;

import com.example.demo.model.ConsumptionLog;
import com.example.demo.service.ConsumptionLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/consumption-logs")
public class ConsumptionLogController {

    private final ConsumptionLogService consumptionLogService;

    @Autowired
    public ConsumptionLogController(ConsumptionLogService consumptionLogService) {
        this.consumptionLogService = consumptionLogService;
    }

    // Get all consumption logs
    @GetMapping
    public ResponseEntity<List<ConsumptionLog>> getAllLogs() {
        List<ConsumptionLog> logs = consumptionLogService.getAllLogs();
        return ResponseEntity.ok(logs);
    }

    // Get consumption log by id
    @GetMapping("/{id}")
    public ResponseEntity<ConsumptionLog> getLogById(@PathVariable Long id) {
        ConsumptionLog log = consumptionLogService.getLogById(id);
        return ResponseEntity.ok(log);
    }

    // Add a new consumption log
    @PostMapping
    public ResponseEntity<ConsumptionLog> createLog(@RequestBody ConsumptionLog log) {
        ConsumptionLog createdLog = consumptionLogService.createLog(log);
        return ResponseEntity.ok(createdLog);
    }

    // Update an existing log
    @PutMapping("/{id}")
    public ResponseEntity<ConsumptionLog> updateLog(@PathVariable Long id, @RequestBody ConsumptionLog log) {
        ConsumptionLog updatedLog = consumptionLogService.updateLog(id, log);
        return ResponseEntity.ok(updatedLog);
    }

    // Delete a log
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLog(@PathVariable Long id) {
        consumptionLogService.deleteLog(id);
        return ResponseEntity.noContent().build();
    }
}
