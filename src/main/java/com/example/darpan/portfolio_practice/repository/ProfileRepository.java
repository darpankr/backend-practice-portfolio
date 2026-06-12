package com.example.darpan.portfolio_practice.repository;

import com.example.darpan.portfolio_practice.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ProfileRepository extends JpaRepository<Profile, UUID> {

    Optional<Profile> findByActiveTrue();
}
