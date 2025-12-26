package com.example.demo.controller;

import com.example.demo.model.ConsumptionLog;
import com.example.demo.service.ConsumptionLogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/consumption-logs")
public class ConsumptionLogController {

    private final ConsumptionLogService service;

    public ConsumptionLogController(ConsumptionLogService service) {
        this.service = service;
    }

    @PostMapping
    public ConsumptionLog save(@RequestBody ConsumptionLog log) {
        return service.save(log);
    }

    @GetMapping("/{id}")
    public ConsumptionLog getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<ConsumptionLog> getAll() {
        return service.getAll();
    }
}
