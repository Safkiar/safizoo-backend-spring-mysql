package com.safizoo.safiizoo_shop.service;

import com.safizoo.safiizoo_shop.dao.CustomerRepository;
import com.safizoo.safiizoo_shop.dto.Purchase;
import com.safizoo.safiizoo_shop.dto.PurchaseResponse;
import com.safizoo.safiizoo_shop.entity.Address;
import com.safizoo.safiizoo_shop.entity.Customer;
import com.safizoo.safiizoo_shop.entity.Order;
import com.safizoo.safiizoo_shop.entity.OrderItem;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private CustomerRepository customerRepository;

    public CheckoutServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        Order order = purchase.getOrder();
        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);
        Set<OrderItem> orderItems = purchase.getOrderItems();
        orderItems.forEach(item -> order.add(item));
        order.setBillingAddress(purchase.getBillingAddress());
        order.setShippingAddress(purchase.getShippingAddress());
        Customer customer = purchase.getCustomer();
        customer.add(order);
        customerRepository.save(customer);
        return new PurchaseResponse(orderTrackingNumber);
    }

private String generateOrderTrackingNumber() {
    return UUID.randomUUID().toString();

}
}
