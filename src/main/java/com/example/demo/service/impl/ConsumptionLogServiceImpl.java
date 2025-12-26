package com.example.demo.service.impl;

import com.example.demo.model.ConsumptionLog;
import com.example.demo.repository.ConsumptionLogRepository;
import com.example.demo.service.ConsumptionLogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsumptionLogServiceImpl implements ConsumptionLogService {

    private final ConsumptionLogRepository logRepository;

    public ConsumptionLogServiceImpl(ConsumptionLogRepository logRepository) {
        this.logRepository = logRepository;
    }

    @Override
    public List<ConsumptionLog> getAllLogs() {
        return logRepository.findAll();
    }

    @Override
    public ConsumptionLog getLogById(Long id) {
        return logRepository.findById(id).orElseThrow(() -> new RuntimeException("Log not found"));
    }

    @Override
    public ConsumptionLog createLog(ConsumptionLog log) {
        return logRepository.save(log);
    }

    @Override
    public ConsumptionLog updateLog(Long id, ConsumptionLog log) {
        ConsumptionLog existingLog = getLogById(id);
        existingLog.setProductId(log.getProductId());
        existingLog.setQuantity(log.getQuantity());
        existingLog.setDate(log.getDate());
        return logRepository.save(existingLog);
    }

    @Override
    public void deleteLog(Long id) {
        logRepository.deleteById(id);
    }
}
