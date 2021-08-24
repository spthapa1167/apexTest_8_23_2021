package com.apex.satya.satyaApiWork.model;

import org.springframework.stereotype.Component;

import java.util.List;

public class RewardSummary {
    private Integer customerId;
    private String customerName;
    private List<TotalRewardPerMonth> summary;

    public RewardSummary(Integer customerId, String customerName, List<TotalRewardPerMonth> summary) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.summary = summary;
    }

    public List<TotalRewardPerMonth> getSummary() {
        return summary;
    }

    public void setSummary(List<TotalRewardPerMonth> summary) {
        this.summary = summary;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
