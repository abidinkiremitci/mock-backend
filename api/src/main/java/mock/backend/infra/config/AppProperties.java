package mock.backend.infra.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app.properties")
@Data
public class AppProperties
{
    private String environment;
}
