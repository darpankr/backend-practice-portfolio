package com.example.darpan.portfolio_practice.repository;

import com.example.darpan.portfolio_practice.model.ContactMessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ContactMessageRepository extends JpaRepository<ContactMessage, UUID> {

    Optional<ContactMessage> findTopByOrderByIdAsc();

    List<ContactMessage> findByIsReadFalseOrderByCreatedAtDesc();
}
