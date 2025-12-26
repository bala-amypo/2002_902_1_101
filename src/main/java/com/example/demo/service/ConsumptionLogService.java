package com.example.demo.service;

import com.example.demo.model.ConsumptionLog;
import com.example.demo.repository.ConsumptionLogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsumptionLogService {

    private final ConsumptionLogRepository consumptionLogRepository;

    public ConsumptionLogService(ConsumptionLogRepository consumptionLogRepository) {
        this.consumptionLogRepository = consumptionLogRepository;
    }

    public List<ConsumptionLog> getConsumptionLogsByStockRecord(Long stockRecordId) {
        return consumptionLogRepository.findByStockRecordId(stockRecordId);
    }

    public ConsumptionLog createConsumptionLog(ConsumptionLog log) {
        return consumptionLogRepository.save(log);
    }
}
