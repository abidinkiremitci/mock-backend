package mock.backend.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by semihunaldi on 31.03.2017.
 */

@SpringBootApplication
@EnableJpaRepositories("mock.backend.api.*")
@ComponentScan(basePackages = {"mock.backend.api.*"})
@EntityScan("mock.backend.api.model.*")
@EnableAutoConfiguration
public class ResourceServerApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(ResourceServerApplication.class,args);
    }
}
