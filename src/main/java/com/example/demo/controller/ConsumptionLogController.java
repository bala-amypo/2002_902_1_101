package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.ConsumptionLog;
import com.example.demo.service.ConsumptionLogService;

@RestController
@RequestMapping("/consumption-logs")
public class ConsumptionLogController {

    @Autowired
    private ConsumptionLogService consumptionLogService;

    @PostMapping
    public ConsumptionLog create(@RequestBody ConsumptionLog log) {
        return consumptionLogService.create(log);
    }

    @GetMapping
    public List<ConsumptionLog> getAll() {
        return consumptionLogService.getAll();
    }

    @GetMapping("/{id}")
    public ConsumptionLog getById(@PathVariable Long id) {
        return consumptionLogService.getById(id);
    }
}
