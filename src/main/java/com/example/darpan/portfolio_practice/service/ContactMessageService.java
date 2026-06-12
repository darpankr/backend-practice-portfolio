package com.example.darpan.portfolio_practice.service;

import com.example.darpan.portfolio_practice.dto.request.ContactRequest;
import com.example.darpan.portfolio_practice.dto.response.ContactResponse;
import com.example.darpan.portfolio_practice.model.ContactMessage;
import com.example.darpan.portfolio_practice.repository.ContactMessageRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Builder
public class ContactMessageService {

    private final ContactMessageRepository contactMessageRepository;

    // Save new Message
    public ContactResponse saveMessage(ContactRequest contactRequest){
        ContactMessage newMessage = ContactMessage.builder()
                .name(contactRequest.getName())
                .email(contactRequest.getEmail())
                .message(contactRequest.getMessage())
                .build();
        return ContactResponse.from(contactMessageRepository.save(newMessage));
    }

    //get all messages
    public List<ContactResponse> getAllMessages(){

        return contactMessageRepository.findAll()
                .stream()
                .map(ContactResponse::from)
                .collect(Collectors.toList());
    }

    //Get latest messages
    public ContactResponse getLatestMessage(){
        return contactMessageRepository.findTopByOrderByIdAsc()
                .map(ContactResponse::from)
                .orElseThrow(() -> new RuntimeException("Data not available"));
    }

    //get unread messages
    public List<ContactResponse> getUnreadMessages(){
        return contactMessageRepository.findByIsReadFalseOrderByCreatedAtDesc()
                .stream()
                .map(ContactResponse::from)
                .collect(Collectors.toList());
    }

    //Read Message By Id
    public ContactResponse getMessageById(UUID uuid){

        ContactMessage message = contactMessageRepository.findById(uuid)
                .orElseThrow(() -> new RuntimeException("Messages not found for id: "+ uuid));

        message.setRead(true);
        ContactMessage res = contactMessageRepository.save(message);

        return ContactResponse.from(res);
    }
}
