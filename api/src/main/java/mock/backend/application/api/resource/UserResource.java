package mock.backend.application.api.resource;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import mock.backend.infra.rest.AbstractResource;

import java.util.Date;

/**
 * Created by AbidinK on 3.10.2017.
 */
@ApiModel(value="User Resource class", description="represents an object request or response for User")
@Data
public class UserResource extends AbstractResource {

    @ApiModelProperty(value = "represents id of user entity")
    private String id;

    @ApiModelProperty(value = "represents first name of user")
    private String firstName;

    @ApiModelProperty(value = "represents last name of user")
    private String lastName;

    @ApiModelProperty(value = "represents user name of user")
    private String userName;

    @ApiModelProperty(value = "represents email of user")
    private String email;

    @ApiModelProperty(value = "represents mobile phone of user")
    private String mobilePhone;

    @ApiModelProperty(value = "represents age of user")
    private Integer age;

    @ApiModelProperty(value = "represents location of user")
    private String location;

    @ApiModelProperty(value = "represents timezone of user")
    private String timeZone;

    @ApiModelProperty(value = "represents create time of user data")
    private Date createTime;

    @ApiModelProperty(value = "represents update time of user data")
    private Date updateTime;

    public UserResource() {
    }

    @Builder
    public UserResource(String id, String firstName, String lastName, String userName, String email, String mobilePhone, Integer age, String location, String timeZone, Date createTime, Date updateTime) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.mobilePhone = mobilePhone;
        this.age = age;
        this.location = location;
        this.timeZone = timeZone;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }
}
