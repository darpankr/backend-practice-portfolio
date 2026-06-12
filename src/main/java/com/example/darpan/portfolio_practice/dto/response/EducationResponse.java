package com.example.darpan.portfolio_practice.dto.response;

import com.example.darpan.portfolio_practice.model.Education;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;


@Data
@Builder
public class EducationResponse {

    private UUID id;
    private String degree;
    private String institution;
    private String year;
    private String description;
    private Integer sortOrder;

    public static EducationResponse from(Education education) {
        return EducationResponse.builder()
                .id(education.getId())
                .degree(education.getDegree())
                .institution(education.getInstitution())
                .year(education.getYear())
                .description(education.getDescription())
                .sortOrder(education.getSortOrder())
                .build();
    }
}
