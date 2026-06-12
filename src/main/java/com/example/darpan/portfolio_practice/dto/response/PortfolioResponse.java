package com.example.darpan.portfolio_practice.dto.response;


import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@Builder
public class PortfolioResponse {

    private  ProfileResponse profileResponse;

//    private Map<String, List<String>> skills;
    private List<SkillResponse> skills;

    private List<ProjectResponse> projects;
    private List<ExperienceResponse> experiences;
    private List<EducationResponse> education;
}
