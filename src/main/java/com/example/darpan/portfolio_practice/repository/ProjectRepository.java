package com.example.darpan.portfolio_practice.repository;

import com.example.darpan.portfolio_practice.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProjectRepository extends JpaRepository<Project, UUID> {
}
