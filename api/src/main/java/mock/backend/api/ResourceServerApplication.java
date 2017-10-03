package mock.backend.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import static com.fasterxml.jackson.databind.DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS;
import static com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS;

@SpringBootApplication
@EnableJpaRepositories("mock.backend.api.*")
@ComponentScan(basePackages = {"mock.backend.api.*"})
@EntityScan("mock.backend.api.*")
@EnableAutoConfiguration
@EnableResourceServer
public class ResourceServerApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(ResourceServerApplication.class,args);
    }

    @Bean
    @Primary
    public ObjectMapper objectMapper() {
        return new ObjectMapper()
                .registerModule(new Jdk8Module())
                .configure(USE_BIG_DECIMAL_FOR_FLOATS, true)
                .configure(WRITE_DATES_AS_TIMESTAMPS, false);
    }
}
