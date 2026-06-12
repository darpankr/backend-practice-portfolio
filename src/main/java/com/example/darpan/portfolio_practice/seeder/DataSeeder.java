package com.example.darpan.portfolio_practice.seeder;

import com.example.darpan.portfolio_practice.model.*;
import com.example.darpan.portfolio_practice.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {

    private final ProfileRepository profileRepository;
    private final SkillRepository skillRepository;
    private final ProjectRepository projectRepository;
    private final ExperienceRepository experienceRepository;
    private final EducationRepository educationRepository;

    @Override
    public void run(String... args){
        log.info("Running Database seeder.....");
        seedProfile();
        seedEducation();
        seedSkils();
        seedExperience();
        seedProjects();
    }

    public void seedProfile(){
        if(profileRepository.count() > 0){
            log.info("Profile already exist.. skipping");
            return;
        }

        log.info("Seeding profile");
        Profile profile = Profile.builder()
                .name("Darpan Kumar")
                .title("Full Stack Developer")
                .bio("I'm a passionate software engineer with over 2 years of experience " +
                        "creating digital solutions that make a difference. I love turning " +
                        "complex problems into simple, beautiful, and intuitive solutions.")
                .hobbies(List.of("Cycling", "Driving"))
                .location("Bangalore, India")
                .email("darpankumarsing92@gmail.com")
                .phone("+91 7908518100")
                .githubUrl("https://github.com/YOUR_GITHUB_USERNAME")
                .linkedInUrl("https://linkedin.com/in/YOUR_LINKEDIN_ID")
                .profileImageUrl("")
                .active(true)
                .build();

        profileRepository.save(profile);
        log.info("Profile Seeded");
    }

    void seedSkils(){
        if (skillRepository.count() > 0) {
            log.info("Skills already exist — skipping.");
            return;
        }
        log.info("Seeding skills...");
        List<Skill> skills = List.of(
                // Languages
                Skill.builder().catagory("Languages").name("JavaScript").sortOrder(1).build(),
                Skill.builder().catagory("Languages").name("TypeScript").sortOrder(2).build(),
                Skill.builder().catagory("Languages").name("Python").sortOrder(3).build(),
                Skill.builder().catagory("Languages").name("Java").sortOrder(4).build(),
                Skill.builder().catagory("Languages").name("C++").sortOrder(5).build(),
                Skill.builder().catagory("Languages").name("C").sortOrder(6).build(),

                // Frontend
                Skill.builder().catagory("Frontend").name("React").sortOrder(1).build(),
                Skill.builder().catagory("Frontend").name("Next.js").sortOrder(2).build(),
                Skill.builder().catagory("Frontend").name("Angular").sortOrder(3).build(),
                Skill.builder().catagory("Frontend").name("Tailwind CSS").sortOrder(4).build(),
                Skill.builder().catagory("Frontend").name("Bootstrap").sortOrder(5).build(),
                Skill.builder().catagory("Frontend").name("ShadCN").sortOrder(6).build(),

                // Backend
                Skill.builder().catagory("Backend").name("Spring Boot").sortOrder(1).build(),
                Skill.builder().catagory("Backend").name("FastAPI").sortOrder(2).build(),
                Skill.builder().catagory("Backend").name("Django").sortOrder(3).build(),
                Skill.builder().catagory("Backend").name("REST APIs").sortOrder(4).build(),

                // Database
                Skill.builder().catagory("Database").name("PostgreSQL").sortOrder(1).build(),
                Skill.builder().catagory("Database").name("MySQL").sortOrder(2).build(),
                Skill.builder().catagory("Database").name("MongoDB").sortOrder(3).build(),
                Skill.builder().catagory("Database").name("SQLite").sortOrder(4).build(),

                // Tools
                Skill.builder().catagory("Tools").name("Git").sortOrder(1).build(),
                Skill.builder().catagory("Tools").name("Docker").sortOrder(2).build(),
                Skill.builder().catagory("Tools").name("AWS").sortOrder(3).build(),
                Skill.builder().catagory("Tools").name("Vercel").sortOrder(4).build(),
                Skill.builder().catagory("Tools").name("Figma").sortOrder(5).build(),
                Skill.builder().catagory("Tools").name("Linux").sortOrder(6).build()
        );

        skillRepository.saveAll(skills);
        log.info("Seeded {} skills.", skills.size());
    }

    private void seedProjects() {
        if (projectRepository.count() > 0) {
            log.info("Projects already exist — skipping.");
            return;
        }
        log.info("Seeding projects...");
        List<Project> projects = List.of(
                Project.builder()
                        .title("Portfolio Website")
                        .description("A personal portfolio website to showcase my projects " +
                                "and skills, built with Next.js and a Spring Boot backend.")
                        .technologies(List.of("Next.js", "Tailwind CSS", "Spring Boot", "Vercel"))
                        .githubUrl("https://github.com/YOUR_GITHUB/portfolio")
                        .demoUrl("https://darpan-portfolio-theta.vercel.app")
                        .imageUrl("")
                        .sortOrder(1)
                        .build(),

                Project.builder()
                        .title("E-commerce Platform")
                        .description("A full-stack e-commerce application with user authentication, " +
                                "product management, and payment integration.")
                        .technologies(List.of("React", "Node.js", "MongoDB"))
                        .githubUrl("https://github.com/YOUR_GITHUB/ecommerce")
                        .demoUrl("#")
                        .imageUrl("")
                        .sortOrder(2)
                        .build(),

                Project.builder()
                        .title("Blog Application")
                        .description("A blogging platform where users can create, edit, " +
                                "and share blog posts with a rich text editor.")
                        .technologies(List.of("Django", "PostgreSQL", "Bootstrap"))
                        .githubUrl("https://github.com/YOUR_GITHUB/blog")
                        .demoUrl("#")
                        .imageUrl("")
                        .sortOrder(3)
                        .build()
        );

        projectRepository.saveAll(projects);
        log.info("Seeded {} projects.", projects.size());
    }

    // ── Experience ────────────────────────────────────────────────────────
    private void seedExperience() {
        if (experienceRepository.count() > 0) {
            log.info("Experience already exists — skipping.");
            return;
        }
        log.info("Seeding experience...");
        List<Experience> experience = List.of(
                Experience.builder()
                        .role("Software Engineer")
                        .company("Tech Solutions Inc.")
                        .duration("2021 - Present")
                        .responsibilities(String.join("||",
                                "Developed and maintained web applications using React and Node.js.",
                                "Collaborated with cross-functional teams to deliver high-quality solutions.",
                                "Implemented RESTful APIs and integrated third-party services.",
                                "Participated in agile ceremonies and sprint planning."
                        ))
                        .sortOrder(1)
                        .build(),

                Experience.builder()
                        .role("Intern Software Developer")
                        .company("Innovatech Ltd.")
                        .duration("2020 - 2021")
                        .responsibilities(String.join("||",
                                "Assisted in the development of internal tools using Python and Django.",
                                "Participated in code reviews and contributed to team discussions.",
                                "Wrote unit tests and maintained documentation."
                        ))
                        .sortOrder(2)
                        .build()
        );

        experienceRepository.saveAll(experience);
        log.info("Seeded {} experience entries.", experience.size());
    }

    // ── Education ─────────────────────────────────────────────────────────
    private void seedEducation() {
        if (educationRepository.count() > 0) {
            log.info("Education already exists — skipping.");
            return;
        }
        log.info("Seeding education...");
        List<Education> education = List.of(
                Education.builder()
                        .degree("Bachelor of Technology in Computer Science")
                        .institution("XYZ University")
                        .year("2020")
                        .description("Graduated with focus on software engineering and algorithms.")
                        .sortOrder(1)
                        .build()
        );

        educationRepository.saveAll(education);
        log.info("Seeded {} education entries.", education.size());
    }
}
