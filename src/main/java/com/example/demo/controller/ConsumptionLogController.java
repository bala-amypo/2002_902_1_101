package com.example.demo.controller;

import com.example.demo.model.ConsumptionLog;
import com.example.demo.service.ConsumptionLogService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/consumption")
public class ConsumptionLogController {

    private final ConsumptionLogService service;

    public ConsumptionLogController(ConsumptionLogService service) {
        this.service = service;
    }

    @PostMapping("/{productId}")
    public ConsumptionLog create(
            @PathVariable Long productId,
            @RequestBody ConsumptionLog log) {
        return service.save(productId, log);
    }

    @GetMapping("/{productId}")
    public List<ConsumptionLog> getByProduct(@PathVariable Long productId) {
        return service.getByProduct(productId);
    }

    @GetMapping("/one/{id}")
    public ConsumptionLog getOne(@PathVariable Long id) {
        return service.getById(id);
    }
}
