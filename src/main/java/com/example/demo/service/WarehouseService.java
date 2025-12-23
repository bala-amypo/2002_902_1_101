package com.example.demo.service;

import java.util.List;
import com.example.demo.model.Warehouse;

public interface WarehouseService {

    Warehouse create(Warehouse warehouse);

    List<Warehouse> getAll();

    Warehouse getById(Long id);
}
