package com.example.darpan.portfolio_practice.dto.response;

import com.example.darpan.portfolio_practice.model.Profile;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;


@Data
@Builder
public class ProfileResponse {

    private UUID id;
    private String name;
    private String title;
    private String bio;
    private List<String> hobbies;
    private String location;
    private String email;
    private String phone;
    private String githubUrl;
    private String linkedinUrl;
    private String profileImageUrl;
    private Boolean active;

    // Maps entity → response DTO
    public static ProfileResponse from(Profile profile) {
        return ProfileResponse.builder()
                .id(profile.getId())
                .name(profile.getName())
                .title(profile.getTitle())
                .bio(profile.getBio())
                .hobbies(profile.getHobbies())
                .location(profile.getLocation())
                .email(profile.getEmail())
                .phone(profile.getPhone())
                .githubUrl(profile.getGithubUrl())
                .linkedinUrl(profile.getLinkedInUrl())
                .profileImageUrl(profile.getProfileImageUrl())
                .active(profile.isActive())
                .build();
    }
}
