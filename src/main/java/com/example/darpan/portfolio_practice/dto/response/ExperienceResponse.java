package com.example.darpan.portfolio_practice.dto.response;

import com.example.darpan.portfolio_practice.model.Experience;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class ExperienceResponse {

    private UUID id;
    private String role;
    private String company;
    private String duration;
    private String responsibilities;
    private Integer sortOrder;

    public static ExperienceResponse from(Experience experience) {
        return ExperienceResponse.builder()
                .id(experience.getId())
                .role(experience.getRole())
                .company(experience.getCompany())
                .duration(experience.getDuration())
                .responsibilities(experience.getResponsibilities())
                .build();
    }
}
