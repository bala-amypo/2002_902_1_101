package com.example.demo.service;

import com.example.demo.model.ConsumptionLog;
import java.util.List;

public interface ConsumptionLogService {
    List<ConsumptionLog> getAllLogs();
    ConsumptionLog getLogById(Long id);
    ConsumptionLog createLog(ConsumptionLog log);
    ConsumptionLog updateLog(Long id, ConsumptionLog log);
    void deleteLog(Long id);
}
