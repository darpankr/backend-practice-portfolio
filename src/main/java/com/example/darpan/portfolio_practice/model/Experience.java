package com.example.darpan.portfolio_practice.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "experience")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String company;

    @Column(nullable = false)
    private String duration;

    @Column(nullable = false)
    private String role;

    @Column(columnDefinition = "TEXT")
    private String responsibilities;

    @Column(name = "sort_order")
    @Builder.Default
    private Integer sortOrder = 0;
}
