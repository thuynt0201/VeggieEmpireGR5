package com.project.models;

public class Order {
    int orderId;
    String methorDelivery;
    String time;
    String methorPayment;
    String status;

    public Order(int orderId, String methorDelivery, String time, String methorPayment, String status) {
        this.orderId = orderId;
        this.methorDelivery = methorDelivery;
        this.time = time;
        this.methorPayment = methorPayment;
        this.status = status;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getMethorDelivery() {
        return methorDelivery;
    }

    public void setMethorDelivery(String methorDelivery) {
        this.methorDelivery = methorDelivery;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMethorPayment() {
        return methorPayment;
    }

    public void setMethorPayment(String methorPayment) {
        this.methorPayment = methorPayment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
