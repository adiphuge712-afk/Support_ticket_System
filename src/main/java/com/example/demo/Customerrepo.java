package com.example.demo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.models.Customer;


@Repository
public interface Customerrepo extends  JpaRepository<Customer,Long> {
Optional<Customer> findByEmail(String email);
}

