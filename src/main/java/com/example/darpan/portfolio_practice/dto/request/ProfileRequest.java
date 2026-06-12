package com.example.darpan.portfolio_practice.dto.request;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.bridge.IMessage;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfileRequest {

    private boolean active;

    @NotBlank(message = "Name sis required")
    private String name;

    @NotBlank(message = "Bio is required")
    private String bio;

    @Email(message = "Email is required")
    private String email;

    @NotEmpty(message = "Hobbies required")
    private List<String> hobbies;

    @NotBlank(message = "Phone is requied")
    private String phone;

    @NotBlank(message = "Title is required")
    private String title;

    private String githubUrl;

    private String linkedInUrl;

    private Integer sortOrder;

    private String location;
}
