package com.example.darpan.portfolio_practice.controller;

import com.example.darpan.portfolio_practice.dto.request.ProfileRequest;
import com.example.darpan.portfolio_practice.dto.response.*;
import com.example.darpan.portfolio_practice.service.PortfolioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PortfolioController {

    private final PortfolioService portfolioService;

    @GetMapping("/skills")
    public ResponseEntity<List<SkillResponse>> getAllSkills(){
        return ResponseEntity.ok(portfolioService.getAllSkill());
    }

    @GetMapping("/projects")
    public ResponseEntity<List<ProjectResponse>> getAllProjects(){
        return ResponseEntity.ok(portfolioService.getAllProject());
    }


    @GetMapping("/profile")
    public ResponseEntity<List<ProfileResponse>> getAllProfile(){
        return ResponseEntity.ok(portfolioService.getAllProfile());
    }

    @GetMapping("/profile/active") //findByActiveTrue
    public ResponseEntity<ProfileResponse> getActiveProfile(){
        return ResponseEntity.ok(portfolioService.getActiveProfile());
    }

    //POST NEW PROFILE
    @PostMapping("/profile/new")
    public ResponseEntity<ProfileResponse> postNewProfile(@Valid @RequestBody ProfileRequest profileRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(portfolioService.createNewProfile(profileRequest));
    }

    // Update ACTIVE PROFILE
    @PutMapping("/profile/{uuid}")
    public ResponseEntity<ProfileResponse> doProfileActive(@PathVariable UUID uuid){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(portfolioService.activeProfile(uuid));
    }

    @GetMapping("/portfolio")
    public ResponseEntity<PortfolioResponse> getPortfolio(){
        return ResponseEntity.ok(portfolioService.getPortfolio());
    }

    @GetMapping("/experience")
    public ResponseEntity<List<ExperienceResponse>> getAllExperience(){
        return ResponseEntity.ok(portfolioService.getAllExperience());
    }

    @GetMapping("/experience/roles")
    public ResponseEntity<List<String>> getExperienceRole(){
        return ResponseEntity.ok(portfolioService.getExperienceRole());
    }

    @GetMapping("/education")
    public ResponseEntity<List<EducationResponse>> getAllEducation(){
        return ResponseEntity
                .ok(portfolioService.getAllEducation());
    }

}


