package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.models.Staff;
import com.models.Tickit;
@Repository
public interface Tickitrepo extends JpaRepository<Tickit,Long>{
//	List<Tickit> findByAssignticketstaff(String s);
	List<Tickit> findByStid(Staff s);
}
