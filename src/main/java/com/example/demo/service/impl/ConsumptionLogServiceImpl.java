package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.ConsumptionLog;
import com.example.demo.repository.ConsumptionLogRepository;
import com.example.demo.service.ConsumptionLogService;

@Service
public class ConsumptionLogServiceImpl implements ConsumptionLogService {

    @Autowired
    private ConsumptionLogRepository consumptionLogRepository;

    @Override
    public ConsumptionLog create(ConsumptionLog log) {
        return consumptionLogRepository.save(log);
    }

    @Override
    public List<ConsumptionLog> getAll() {
        return consumptionLogRepository.findAll();
    }

    @Override
    public ConsumptionLog getById(Long id) {
        return consumptionLogRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("ConsumptionLog not found"));
    }
}
