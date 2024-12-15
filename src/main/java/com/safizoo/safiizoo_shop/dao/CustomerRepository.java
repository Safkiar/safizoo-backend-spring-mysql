package com.safizoo.safiizoo_shop.dao;

import com.safizoo.safiizoo_shop.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
