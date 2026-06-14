package com.example.darpan.portfolio_practice.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "profile")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Builder.Default
    private boolean active = false;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String bio;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private List<String> hobbies;

    private String location;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String title;

    @Column(name = "github_url")
    private String githubUrl;

    @Column(name = "linkedIn_url")
    private String linkedInUrl;

    @Column(name = "profile_url")
    private String profileImageUrl;

    @Column(name = "sort_order")
    @Builder.Default
    private Integer sortOrder = 0;
}
