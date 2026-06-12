package com.example.darpan.portfolio_practice.repository;

import com.example.darpan.portfolio_practice.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SkillRepository extends JpaRepository<Skill, UUID> {
}
