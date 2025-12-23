package com.example.demo.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Warehouse;
import com.example.demo.repository.WarehouseRepository;
import com.example.demo.service.WarehouseService;

@Service
public class WarehouseServiceImpl implements WarehouseService {

    @Autowired
    private WarehouseRepository warehouseRepository;

    @Override
    public Warehouse create(Warehouse warehouse) {
        warehouse.setCreatedAt(LocalDateTime.now());
        return warehouseRepository.save(warehouse);
    }

    @Override
    public List<Warehouse> getAll() {
        return warehouseRepository.findAll();
    }

    @Override
    public Warehouse getById(Long id) {
        return warehouseRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Warehouse not found"));
    }
}
