package com.database.foodtruck.repository;

import com.database.foodtruck.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
    Customer findByUserName(String username);
    void deleteByUserName(String username);

    // TODO: @Hongyu
}
