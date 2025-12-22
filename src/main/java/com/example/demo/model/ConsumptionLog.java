package com.example.demo.model;

import java.time.LocalDate;

public class ConsumptionLog {

    private Long id;
    private StockRecord stockRecord;
    private Integer consumedQuantity;
    private LocalDate consumedDate;

    public ConsumptionLog() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StockRecord getStockRecord() {
        return stockRecord;
    }

    public void setStockRecord(StockRecord stockRecord) {
        this.stockRecord = stockRecord;
    }

    public Integer getConsumedQuantity() {
        return consumedQuantity;
    }

    public void setConsumedQuantity(Integer consumedQuantity) {
        this.consumedQuantity = consumedQuantity;
    }

    public LocalDate getConsumedDate() {
        return consumedDate;
    }

    public void setConsumedDate(LocalDate consumedDate) {
        this.consumedDate = consumedDate;
    }
}
