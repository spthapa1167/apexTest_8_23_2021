package com.apex.satya.satyaApiWork.entity;

import java.util.Date;

public class Transactions{
    private Integer id;
    private String desc;
    private Double amount;
    private Date txnDate;
    private Integer customerId;


    public Transactions(Integer id, String desc, Double amount, Date txnDate, Integer customerId) {
        this.id = id;
        this.desc = desc;
        this.amount = amount;
        this.txnDate = txnDate;
        this.customerId = customerId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getTxnDate() {
        return txnDate;
    }

    public void setTxnDate(Date txnDate) {
        this.txnDate = txnDate;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
}