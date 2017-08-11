package mock.backend.api.ws.user.model;

import mock.backend.api.ws.BaseResult;
import mock.backend.api.enums.SpecialExceptions;
import mock.backend.api.model.user.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by semihunaldi on 23.08.2016.
 */

@EqualsAndHashCode(callSuper = false)
@Data
public class UserDTO extends BaseResult
{
    private String id;

    private String firstName;

    private String lastName;

    private String userName;

    private String email;

    public UserDTO(Integer errorCode, String errorDescription)
    {
        super(errorCode,errorDescription);
    }

    public UserDTO(SpecialExceptions specialExceptions)
    {
        super(specialExceptions.getErrorCode(),specialExceptions.getErrorDescription());
    }

    public UserDTO()
    {
    }

    public static UserDTO create(User user)
    {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setUserName(user.getUserName());
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }
}
