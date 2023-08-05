package com.ticket.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ticket.book.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

}
