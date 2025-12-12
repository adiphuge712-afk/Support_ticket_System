package com.example.demo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.models.Admin;


@Repository
public interface Adminrepo extends JpaRepository<Admin,Long> {
	Optional<Admin> findByEmail(String email);
}
