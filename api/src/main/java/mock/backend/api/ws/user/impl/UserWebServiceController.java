package mock.backend.api.ws.user.impl;

import com.google.common.base.Preconditions;
import mock.backend.api.enums.SpecialExceptions;
import mock.backend.api.exceptions.UserException;
import mock.backend.api.model.user.User;
import mock.backend.api.services.user.UserService;
import mock.backend.api.ws.BaseRestController;
import mock.backend.api.ws.user.UserWebService;
import mock.backend.api.ws.user.model.CreateUserDTO;
import mock.backend.api.ws.user.model.UserDTO;
import lombok.Setter;
import org.apache.commons.lang.StringUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by semihunaldi on 17.8.2015.
 */
@RestController
public class UserWebServiceController extends BaseRestController implements UserWebService
{
    @Setter
    @Resource(name = "userService")
    private UserService userService;

    public UserDTO queryUserByEmail(@RequestParam(value="email", defaultValue="") String email)
    {
        try
        {
            User user = userService.findUserByEmail(email);
            if(user != null)
            {
                return UserDTO.create(user);
            }
            else
            {
                throw new UserException(SpecialExceptions.USER_NOT_FOUND_EXCEPTION);
            }
        }
        catch (UserException e)
        {
            logger.error("queryUserByEmail error",e);
            return new UserDTO(e.getErrorCode(),e.getErrorDescription());
        }
        catch (Exception e)
        {
            logger.error("queryUserByEmail error",e);
            return new UserDTO(SpecialExceptions.ERROR);
        }
    }

    @Override
    public UserDTO queryUserById(@RequestParam(value = "id", defaultValue = "") String id)
    {
        try
        {
            User user = userService.findUserById(id);
            if(user != null)
            {
                return UserDTO.create(user);
            }
            else
            {
                throw new UserException(SpecialExceptions.USER_NOT_FOUND_EXCEPTION);
            }
        }
        catch (UserException e)
        {
            logger.error("queryUserById error",e);
            return new UserDTO(e.getErrorCode(),e.getErrorDescription());
        }
        catch (Exception e)
        {
            logger.error("queryUserById error",e);
            return new UserDTO(SpecialExceptions.ERROR);
        }
    }

    @Override
    public UserDTO queryUserByUserName(@RequestParam(value = "userName", defaultValue = "") String userName)
    {
        try
        {
            User user = userService.findUserByUserName(userName);
            if(user != null)
            {
                return UserDTO.create(user);
            }
            else
            {
                throw new UserException(SpecialExceptions.USER_NOT_FOUND_EXCEPTION);
            }
        }
        catch (UserException e)
        {
            logger.error("queryUserByUserName error",e);
            return new UserDTO(e.getErrorCode(),e.getErrorDescription());
        }
        catch (Exception e)
        {
            logger.error("queryUserByUserName error",e);
            return new UserDTO(SpecialExceptions.ERROR);
        }
    }

    @Override
    public CreateUserDTO createUser(@RequestBody CreateUserDTO createUserDTO)
    {
        try
        {
            User user = createUserDTO.createUserEntity();
            user = userService.saveUser(user);
            return CreateUserDTO.createCreateUserDTO(user);
        }
        catch (DataIntegrityViolationException e)
        {
            logger.error("createUser error",e);
            UserException userException = new UserException(SpecialExceptions.USER_EXISTS_EXCEPTION);
            return new CreateUserDTO(userException.getErrorCode(),userException.getErrorDescription());
        }
        catch (Exception e)
        {
            logger.error("createUser error",e);
            return new CreateUserDTO(SpecialExceptions.ERROR);
        }
    }

    @Override
    public CreateUserDTO updateUser(@RequestBody CreateUserDTO createUserDTO)
    {
        try
        {
            Preconditions.checkNotNull(createUserDTO,"request can not be empty");
            Preconditions.checkArgument(StringUtils.isNotBlank(createUserDTO.getUserId()),"user id cannot be empty");
            User user = userService.findUserById(createUserDTO.getUserId());
            if(user == null)
            {
                throw new UserException(SpecialExceptions.USER_NOT_FOUND_EXCEPTION);
            }
            CreateUserDTO.updateUserEntityFields(user,createUserDTO);
            user = userService.saveUser(user);
            return CreateUserDTO.createCreateUserDTO(user);
        }
        catch (DataIntegrityViolationException e)
        {
            logger.error("updateUser error",e);
            UserException userException = new UserException(SpecialExceptions.USER_EXISTS_EXCEPTION);
            return new CreateUserDTO(userException.getErrorCode(),userException.getErrorDescription());
        }
        catch (Exception e)
        {
            logger.error("updateUser error",e);
            return new CreateUserDTO(SpecialExceptions.ERROR);
        }
    }
}
