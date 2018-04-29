package com.consumer.model;

import java.time.LocalDateTime;
import java.util.Date;

public class Order {
    private String id;

    private String provider;

    private String tradeId;

    private Long num;

    private Integer status;

    private LocalDateTime gmtCreate;

    private LocalDateTime gmtModitied;

    private String products;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider == null ? null : provider.trim();
    }

    public String getTradeId() {
        return tradeId;
    }

    public void setTradeId(String tradeId) {
        this.tradeId = tradeId == null ? null : tradeId.trim();
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDateTime getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(LocalDateTime gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public LocalDateTime getGmtModitied() {
        return gmtModitied;
    }

    public void setGmtModitied(LocalDateTime gmtModitied) {
        this.gmtModitied = gmtModitied;
    }

    public String getProducts() {
        return products;
    }

    public void setProducts(String products) {
        this.products = products == null ? null : products.trim();
    }
}