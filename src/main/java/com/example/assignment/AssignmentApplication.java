package com.example.assignment;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * The main entry point for the Assignment application.
 */
@SpringBootApplication
public class AssignmentApplication {
    /**
     * The main method that starts the Spring Boot application.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(AssignmentApplication.class, args);
    }
    /**
     * Creates a bean for the UserService using the provided UserRepository.
     *
     * @param userRepository the UserRepository used by the UserService
     * @return the UserService instance
     */
    @Bean
    public UserService userService(UserRepository userRepository) {
        return new UserService(userRepository);}
}
