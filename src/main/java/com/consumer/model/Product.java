package com.consumer.model;

import java.time.LocalDateTime;
import java.util.Date;

public class Product {
    private Long id;

    private String product;

    private Integer isParent;

    private Long parent;

    private LocalDateTime modityTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product == null ? null : product.trim();
    }

    public Integer getIsParent() {
        return isParent;
    }

    public void setIsParent(Integer isParent) {
        this.isParent = isParent;
    }

    public Long getParent() {
        return parent;
    }

    public void setParent(Long parent) {
        this.parent = parent;
    }

    public LocalDateTime getModityTime() {
        return modityTime;
    }

    public void setModityTime(LocalDateTime modityTime) {
        this.modityTime = modityTime;
    }
}