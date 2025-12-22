package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "prediction_rules")
public class PredictionRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ruleName;
    private Integer averageDaysWindow;
    private Integer minDailyUsage;
    private Integer maxDailyUsage;
    private LocalDateTime createdAt;

    public PredictionRule() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public Integer getAverageDaysWindow() {
        return averageDaysWindow;
    }

    public void setAverageDaysWindow(Integer averageDaysWindow) {
        this.averageDaysWindow = averageDaysWindow;
    }

    public Integer getMinDailyUsage() {
        return minDailyUsage;
    }

    public void setMinDailyUsage(Integer minDailyUsage) {
        this.minDailyUsage = minDailyUsage;
    }

    public Integer getMaxDailyUsage() {
        return maxDailyUsage;
    }

    public void setMaxDailyUsage(Integer maxDailyUsage) {
        this.maxDailyUsage = maxDailyUsage;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
