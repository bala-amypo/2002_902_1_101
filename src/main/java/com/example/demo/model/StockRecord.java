package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "stock_records")
public class StockRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Product product;

    @ManyToOne
    private Warehouse warehouse;

    private Integer currentQuantity;
    private Integer reorderThreshold;
    private LocalDateTime lastUpdated;

    public StockRecord() {
    }

    public StockRecord(Long id, Product product, Warehouse warehouse,
                       Integer currentQuantity, Integer reorderThreshold,
                       LocalDateTime lastUpdated) {
        this.id = id;
        this.product = product;
        this.warehouse = warehouse;
        this.currentQuantity = currentQuantity;
        this.reorderThreshold = reorderThreshold;
        this.lastUpdated = lastUpdated;
    }

    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }
 
    public void setProduct(Product product) {
        this.product = product;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }
 
    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public Integer getCurrentQuantity() {
        return currentQuantity;
    }
 
    public void setCurrentQuantity(Integer currentQuantity) {
        this.currentQuantity = currentQuantity;
    }

    public Integer getReorderThreshold() {
        return reorderThreshold;
    }
 
    public void setReorderThreshold(Integer reorderThreshold) {
        this.reorderThreshold = reorderThreshold;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }
 
    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
