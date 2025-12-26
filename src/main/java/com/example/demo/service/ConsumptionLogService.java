package com.example.demo.service;

import com.example.demo.model.ConsumptionLog;
import java.util.List;

public interface ConsumptionLogService {
    ConsumptionLog save(Long productId, ConsumptionLog log);
    List<ConsumptionLog> getByProduct(Long productId);
    ConsumptionLog getById(Long id);
}
