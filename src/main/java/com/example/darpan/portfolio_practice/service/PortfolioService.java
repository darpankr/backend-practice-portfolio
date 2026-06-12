package com.example.darpan.portfolio_practice.service;

import com.example.darpan.portfolio_practice.dto.request.ProfileRequest;
import com.example.darpan.portfolio_practice.dto.response.*;
import com.example.darpan.portfolio_practice.model.Experience;
import com.example.darpan.portfolio_practice.model.Profile;
import com.example.darpan.portfolio_practice.repository.*;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Builder
public class PortfolioService {

    private final SkillRepository skillRepository;
    private final ProfileRepository profileRepository;
    private final ProjectRepository projectRepository;
    private final ExperienceRepository experienceRepository;
    private final EducationRepository educationRepository;

    // get all skills

//    public Map<String, List<SkillResponse>> getAllSkill(){
//        return skillRepository.findAll().stream()
//                .collect(Collectors.groupingBy(
//                        skill -> skill
//                ));
//    }

    public List<SkillResponse> getAllSkill(){
        return skillRepository.findAll()
                .stream()
                .map(SkillResponse::from)
                .collect(Collectors.toList());
    }

    // Get all project
    public List<ProjectResponse> getAllProject(){
        return projectRepository.findAll().stream()
                .map(ProjectResponse::from)
                .collect(Collectors.toList());
    }

    // get all profile
    public List<ProfileResponse> getAllProfile(){
        return profileRepository.findAll()
                .stream()
                .map(ProfileResponse::from)
                .collect(Collectors.toList());
    }

    // get active profile
    public ProfileResponse getActiveProfile(){
        Profile profile = profileRepository.findByActiveTrue()
                .orElseThrow(() -> new RuntimeException("Active profile doesnot exist"));
        return ProfileResponse.from(profile);
    }

    //post the profile new
    public ProfileResponse createNewProfile(ProfileRequest profileRequest) {

        Profile data = Profile.builder()
                .name(profileRequest.getName())         // ← missing
                .bio(profileRequest.getBio())           // ← missing
                .location(profileRequest.getLocation()) // ← missing
                .githubUrl(profileRequest.getGithubUrl())     // ← missing
                .linkedInUrl(profileRequest.getLinkedInUrl())  // ← missing
                .title(profileRequest.getTitle())
                .email(profileRequest.getEmail())
                .phone(profileRequest.getPhone())
                .active(profileRequest.isActive())
                .hobbies(profileRequest.getHobbies())
                .build();

        if (data.isActive()) {
            profileRepository.findByActiveTrue()
                    .ifPresent(existingActive -> {
                        existingActive.setActive(false);
                        profileRepository.save(existingActive);
                    });
        }

        return ProfileResponse.from(profileRepository.save(data));
    }

    //Activate the profile

    public ProfileResponse activeProfile(UUID uuid){

        Profile doActive = profileRepository.findById(uuid)
                .orElseThrow(() -> new RuntimeException("Profile does not exist for this id"));

        profileRepository.findByActiveTrue()
                .ifPresent(existTrue -> {
                    existTrue.setActive(false);
                    profileRepository.save(existTrue);
                });

        doActive.setActive(true);

        return ProfileResponse.from(profileRepository.save(doActive));

    }

    // get portfolio
    public PortfolioResponse getPortfolio(){

        return PortfolioResponse.builder()
                .profileResponse(getActiveProfile())
                .skills(getAllSkill())
                .projects(getAllProject())
                .experiences(getAllExperience())
                .education(getAllEducation())
                .build();
    }

    // get all experiences
    public List<ExperienceResponse> getAllExperience(){
        return experienceRepository.findAll()
                .stream()
                .map(ExperienceResponse::from)
                .collect(Collectors.toList());
    }

    // get experience role
    public List<String> getExperienceRole(){
         return experienceRepository.findAll()
                .stream()
                .map(Experience::getRole)
                .collect(Collectors.toList());
    }

    //get education all
    public List<EducationResponse> getAllEducation(){
        return educationRepository.findAll()
                .stream()
                .map(EducationResponse::from)
                .collect(Collectors.toList());
    }
}
