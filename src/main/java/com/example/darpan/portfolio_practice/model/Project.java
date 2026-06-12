package com.example.darpan.portfolio_practice.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "projects")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(name = "demo_url")
    private String demoUrl;

    @Column(name = "github_url")
    private String githubUrl;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(nullable = false)
    private List<String> technologies;

    @Column(nullable = false)
    private String title;

    @Column(name = "sort_order")
    @Builder.Default
    private Integer sortOrder = 0;
}
