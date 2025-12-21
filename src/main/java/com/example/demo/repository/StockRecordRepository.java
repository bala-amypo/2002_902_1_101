package com.example.demo.repository;

import com.example.demo.model.StockRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRecordRepository extends JpaRepository<StockRecord, Long> {

    // 🔴 REQUIRED exact method name
    List<StockRecord> findByProductId(Long productId);

    // Used by service + controller
    List<StockRecord> findByWarehouseId(Long warehouseId);
}
