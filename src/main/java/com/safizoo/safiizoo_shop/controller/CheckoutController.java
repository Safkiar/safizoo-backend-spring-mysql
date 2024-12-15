package com.safizoo.safiizoo_shop.controller;

import com.safizoo.safiizoo_shop.dto.Purchase;
import com.safizoo.safiizoo_shop.dto.PurchaseResponse;
import com.safizoo.safiizoo_shop.service.CheckoutService;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

    private static final Logger logger = LoggerFactory.getLogger(CheckoutController.class);

    private final CheckoutService checkoutService;

    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase) {
        // Log incoming request
        logger.info("Received purchase request: {}", purchase);

        // Process the purchase and log the response
        PurchaseResponse response = checkoutService.placeOrder(purchase);
        logger.info("Returning purchase response: {}", response);

        return response;
    }
}