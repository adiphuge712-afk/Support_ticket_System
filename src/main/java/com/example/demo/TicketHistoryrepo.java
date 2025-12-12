package com.example.demo;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.models.TicketHistory;

@Repository
public interface TicketHistoryrepo extends JpaRepository<TicketHistory, Long> {
//List<TicketHistory> findAllByStaffId(long id);
}
