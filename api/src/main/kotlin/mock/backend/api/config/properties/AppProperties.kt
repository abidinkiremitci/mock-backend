package mock.backend.api.config.properties

import lombok.Data
import org.springframework.boot.context.properties.ConfigurationProperties

@Data
@ConfigurationProperties(prefix = "app.properties")
class AppProperties
{
    var testProperty : String? = null
}
