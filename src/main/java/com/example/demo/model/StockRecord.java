package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "stock_records")
public class StockRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 🔥 REQUIRED by StockRecordServiceImpl
    @Column(nullable = false)
    private Long productId;

    // 🔥 REQUIRED by StockRecordServiceImpl
    @Column(nullable = false)
    private Long warehouseId;

    @Column(nullable = false)
    private Integer quantity;
}
