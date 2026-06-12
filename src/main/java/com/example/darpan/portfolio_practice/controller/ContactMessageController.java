package com.example.darpan.portfolio_practice.controller;

import com.example.darpan.portfolio_practice.dto.request.ContactRequest;
import com.example.darpan.portfolio_practice.dto.response.ContactResponse;
import com.example.darpan.portfolio_practice.service.ContactMessageService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/contact")
public class ContactMessageController {

    private final ContactMessageService contactMessageService;

    @PostMapping("/message")
    public ResponseEntity<ContactResponse> postMessage(@Valid @RequestBody ContactRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(contactMessageService.saveMessage(request));
    }

    @GetMapping("/messages")
    public ResponseEntity<List<ContactResponse>> getAllMessage(){
        return ResponseEntity.ok(contactMessageService.getAllMessages());
    }

    @GetMapping("/message/new") //max order
    public ResponseEntity<ContactResponse> getNewMessage(){
        return ResponseEntity.ok(contactMessageService.getLatestMessage());
    }

    @GetMapping("/message/unread") // where read equal to false
    public ResponseEntity<List<ContactResponse>> getAllUnreadMessages(){
        return ResponseEntity.ok(contactMessageService.getUnreadMessages());
    }

    @GetMapping("/message/{uuid}")
    public ResponseEntity<ContactResponse> getMessageById(@PathVariable(required = true) UUID uuid) {
        return ResponseEntity.ok(contactMessageService.getMessageById(uuid));
    }
}
