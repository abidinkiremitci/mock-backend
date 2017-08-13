package mock.backend.api.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by semihunaldi on 31.03.2017.
 */

@ConfigurationProperties(prefix = "app.properties")
@Data
public class AppProperties
{
    private String testProperty;
    private String environment;
}
