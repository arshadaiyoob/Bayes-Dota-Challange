package gg.bayes.challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("gg.bayes.challenge.models")
@EnableJpaRepositories
public class DotaChallengeApplication {

    public static void main(String[] args) {
        SpringApplication.run(DotaChallengeApplication.class, args);
    }

}
