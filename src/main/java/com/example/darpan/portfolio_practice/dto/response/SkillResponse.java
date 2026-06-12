package com.example.darpan.portfolio_practice.dto.response;

import com.example.darpan.portfolio_practice.model.Skill;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
public class SkillResponse {

    private UUID id;
    private String category;
    private String name;
    private Integer sortOrder;

    public static SkillResponse from(Skill skill) {
        return SkillResponse.builder()
                .id(skill.getId())
                .category(skill.getCatagory())
                .name(skill.getName())
                .sortOrder(skill.getSortOrder())
                .build();
    }
}
