package pl.robert.springmvcproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"controller", "repository"})
@EntityScan(basePackages = "model")
@EnableJpaRepositories(basePackages = "repository")
public class SpringmvcProjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringmvcProjectApplication.class, args);
    }
}