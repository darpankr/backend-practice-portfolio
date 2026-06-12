package com.example.darpan.portfolio_practice.dto.response;

import com.example.darpan.portfolio_practice.model.ContactMessage;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Builder
public class ContactResponse {

    private UUID id;
    private String name;
    private String email;
    private String message;
    private LocalDateTime createdAt;
    private Boolean isRead;

    public static ContactResponse from(ContactMessage message) {
        return ContactResponse.builder()
                .id(message.getId())
                .name(message.getName())
                .email(message.getEmail())
                .message(message.getMessage())
                .createdAt(message.getCreatedAt())
                .isRead(message.isRead())
                .build();
    }
}
