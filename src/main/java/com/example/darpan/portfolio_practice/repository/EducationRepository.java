package com.example.darpan.portfolio_practice.repository;

import com.example.darpan.portfolio_practice.model.Education;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EducationRepository extends JpaRepository<Education, UUID> {
}
