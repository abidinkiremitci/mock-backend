package mock.backend.application.api.resource;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Value;
import mock.backend.infra.rest.RestResponsePage;

import java.io.Serializable;

@ApiModel(value="Dinner Recipe Page class", description="represents an object response of a paginated Dinner Recipe")
@Value
public class UserPageResource implements Serializable {

    @ApiModelProperty(value = "represents an Dinner Recipe paginated response")
    private RestResponsePage<UserResource> response;

}
