package com.consumer.model;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
    private String id;

    private Integer status;

    private Date gmtCreate;

    private Date gmtModitied;

    private BigDecimal total;

    private Long buyerId;

    private String buyerName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModitied() {
        return gmtModitied;
    }

    public void setGmtModitied(Date gmtModitied) {
        this.gmtModitied = gmtModitied;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName == null ? null : buyerName.trim();
    }
}