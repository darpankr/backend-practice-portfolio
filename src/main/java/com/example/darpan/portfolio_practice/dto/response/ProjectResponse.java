package com.example.darpan.portfolio_practice.dto.response;

import com.example.darpan.portfolio_practice.model.Project;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class ProjectResponse {

    private UUID id;
    private String title;
    private String description;
    private List<String> technologies;
    private String githubUrl;
    private String demoUrl;
    private String imageUrl;
    private Integer sortOrder;

    public static ProjectResponse from(Project project) {
        return ProjectResponse.builder()
                .id(project.getId())
                .title(project.getTitle())
                .description(project.getDescription())
                .technologies(project.getTechnologies())
                .githubUrl(project.getGithubUrl())
                .demoUrl(project.getDemoUrl())
                .imageUrl(project.getImageUrl())
                .sortOrder(project.getSortOrder())
                .build();
    }
}
