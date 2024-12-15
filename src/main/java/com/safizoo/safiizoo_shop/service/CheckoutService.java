package com.safizoo.safiizoo_shop.service;

import com.safizoo.safiizoo_shop.dto.Purchase;
import com.safizoo.safiizoo_shop.dto.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);
}
