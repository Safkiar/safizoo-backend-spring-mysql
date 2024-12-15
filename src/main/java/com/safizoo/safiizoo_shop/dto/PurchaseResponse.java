package com.safizoo.safiizoo_shop.dto;

import java.util.Objects;

public class PurchaseResponse {

    private final String orderTrackingNumber;

    public PurchaseResponse(String orderTrackingNumber) {
        this.orderTrackingNumber = orderTrackingNumber;
    }

    public String getOrderTrackingNumber() {
        return orderTrackingNumber;
    }

    @Override
    public String toString() {
        return "PurchaseResponse{" +
                "orderTrackingNumber='" + orderTrackingNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchaseResponse that = (PurchaseResponse) o;
        return Objects.equals(orderTrackingNumber, that.orderTrackingNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderTrackingNumber);
    }
}