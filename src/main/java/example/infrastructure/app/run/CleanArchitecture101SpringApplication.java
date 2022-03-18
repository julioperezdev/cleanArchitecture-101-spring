package example.infrastructure.app.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@ComponentScan(basePackages = ["example"])
@EnableJpaRepositories("example.infrastructure.repository")
@EntityScan("example.infrastructure.repository")
public class CleanArchitecture101SpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(CleanArchitecture101SpringApplication.class, args);
    }

}
