package mock.backend.infra.rest;

import lombok.ToString;
import org.springframework.hateoas.ResourceSupport;

import java.util.UUID;

@ToString
public class AbstractResource extends ResourceSupport {

    private String requestUUID = UUID.randomUUID().toString();

    public String getRequestUUID() {
        return requestUUID;
    }
}