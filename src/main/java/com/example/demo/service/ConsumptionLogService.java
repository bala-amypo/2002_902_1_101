package com.example.demo.service;

import java.util.List;
import com.example.demo.model.ConsumptionLog;

public interface ConsumptionLogService {

    ConsumptionLog create(ConsumptionLog log);

    List<ConsumptionLog> getAll();

    ConsumptionLog getById(Long id);
}
