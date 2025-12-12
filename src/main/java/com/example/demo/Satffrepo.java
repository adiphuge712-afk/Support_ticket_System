package com.example.demo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.models.Staff;
@Repository
public interface Satffrepo extends JpaRepository<Staff, Long> {
	Optional<Staff> findByEmail(String email);

}
