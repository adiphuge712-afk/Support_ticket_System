package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.models.Complain;
@Repository
public interface Complainrepo extends  JpaRepository<Complain,Long>{
List<Complain> findByUsername(String username);
}
