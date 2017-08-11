package mock.backend.api.ws.user.model;

import mock.backend.api.enums.SpecialExceptions;
import mock.backend.api.ws.BaseResult;
import mock.backend.api.model.user.User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang.StringUtils;

/**
 * Created by semihunaldi on 23.08.2016.
 */

@EqualsAndHashCode(callSuper = false)
@Data
public class CreateUserDTO extends BaseResult
{
    private String userId;

    private String password;

    private String firstName;

    private String lastName;

    private String userName;

    private String email;

    private String mobilePhone;

    private String token;

    private Integer age;

    private String location;

    private String ipAddress;

    public CreateUserDTO(Integer errorCode, String errorDescription)
    {
        super(errorCode,errorDescription);
    }

    public CreateUserDTO(SpecialExceptions specialExceptions)
    {
        super(specialExceptions.getErrorCode(),specialExceptions.getErrorDescription());
    }

    public CreateUserDTO()
    {
    }

    public User createUserEntity()
    {
        User user = new User();
        setUserCommonFields(user,this);
        user.setPassword(this.password);
        if(StringUtils.isNotBlank(this.ipAddress))
        {
            user.setCreateUserIP(this.ipAddress);
        }
        return user;
    }

    public static void updateUserEntityFields(User user, CreateUserDTO createUserDTO)
    {
        setUserCommonFields(user,createUserDTO);
    }

    private static void setUserCommonFields(User user, CreateUserDTO createUserDTO)
    {
        user.setFirstName(createUserDTO.getFirstName());
        user.setLastName(createUserDTO.getLastName());
        user.setUserName(createUserDTO.getUserName());
        user.setEmail(createUserDTO.getEmail());
        user.setMobilePhone(createUserDTO.getMobilePhone());
        user.setAge(createUserDTO.getAge());
        user.setLocation(createUserDTO.getLocation());
        user.setToken(createUserDTO.getToken());
//        user.setPassword(createUserDTO.getPassword());
        if(StringUtils.isNotBlank(createUserDTO.getUserId()))
        {
            user.setId(createUserDTO.getUserId());
        }
        if(StringUtils.isNotBlank(createUserDTO.getIpAddress()))
        {
//            user.setCreateUserIP(createUserDTO.getIpAddress());
            user.setUpdateUserIP(createUserDTO.getIpAddress());
        }
    }

    public static CreateUserDTO createCreateUserDTO(User user)
    {
        CreateUserDTO createUserDTO = new CreateUserDTO();
        createUserDTO.setFirstName(user.getFirstName());
        createUserDTO.setLastName(user.getLastName());
        createUserDTO.setUserName(user.getUserName());
        createUserDTO.setEmail(user.getEmail());
        createUserDTO.setMobilePhone(user.getMobilePhone());
        createUserDTO.setAge(user.getAge());
        createUserDTO.setLocation(user.getLocation());
        createUserDTO.setToken(user.getToken());
        createUserDTO.setPassword(user.getPassword());
        createUserDTO.setUserId(user.getId());
        createUserDTO.setIpAddress(user.getUpdateUserIP());
        return createUserDTO;
    }
}


//{
//    "userId": "",
//    "password": "test",
//    "firstName": "Semih",
//    "lastName": "Ünaldı",
//    "userName": "semihunaldi",
//    "email": "semihunaldi@test.com",
//    "mobilePhone": "5554443322",
//    "token": "test_token",
//    "age": "50",
//    "location": "İzmir",
//    "ipAddress": "127.0.0.1"
//}