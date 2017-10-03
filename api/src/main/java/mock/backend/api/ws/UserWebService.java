package mock.backend.api.ws;

import com.google.common.base.Preconditions;
import lombok.Setter;
import mock.backend.api.exceptions.SpecialException;
import mock.backend.api.exceptions.UserException;
import mock.backend.api.model.enums.ResultEnum;
import mock.backend.api.model.User;
import mock.backend.api.services.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/user")
public class UserWebService extends BaseRestController {
    @Setter
    @Resource(name = "userService")
    private UserService userService;

    @RequestMapping(value = "/queryUserByEmail", method = {RequestMethod.GET})
    public GenericResult<User> queryUserByEmail(@RequestParam(value="email", defaultValue="") String email)
    {
        GenericResult<User> result;
        try {
            User user = userService.findUserByEmail(email);
            if(user != null)
            {
                result = GenericResult.createInstance(user);
            }
            else
            {
                throw new UserException(ResultEnum.USER_NOT_FOUND_EXCEPTION);
            }
        }  catch (DataIntegrityViolationException e) {
            logger.error("queryUserByEmail error",e);
            result = GenericResult.createInstance(ResultEnum.USER_EXISTS_EXCEPTION);
        } catch (SpecialException e) {
            logger.error("queryUserByEmail error", e);
            result = GenericResult.createInstance(e.getResultEnum());
        } catch (Exception e) {
            logger.error("queryUserByEmail error",e);
            result = GenericResult.createInstance(ResultEnum.ERROR);
        }
        return result;
    }

    @RequestMapping(value = "/queryUserById", method = {RequestMethod.GET})
    public GenericResult<User> queryUserById(@RequestParam(value = "id", defaultValue = "") String id)
    {
        GenericResult<User> result;
        try {
            User user = userService.findUserById(id);
            if(user != null) {
                result = GenericResult.createInstance(user);
            }
            else {
                throw new UserException(ResultEnum.USER_NOT_FOUND_EXCEPTION);
            }
        } catch (DataIntegrityViolationException e) {
            logger.error("queryUserById error",e);
            result = GenericResult.createInstance(ResultEnum.USER_EXISTS_EXCEPTION);
        } catch (SpecialException e) {
            logger.error("queryUserById error", e);
            result = GenericResult.createInstance(e.getResultEnum());
        } catch (Exception e) {
            logger.error("queryUserById error",e);
            result = GenericResult.createInstance(ResultEnum.ERROR);
        }
        return result;
    }

    @RequestMapping(value = "/queryUserByUserName", method = {RequestMethod.GET})
    public GenericResult<User> queryUserByUserName(@RequestParam(value = "userName", defaultValue = "") String userName)
    {
        GenericResult<User> result;
        try {
            User user = userService.findUserByUserName(userName);
            if(user != null) {
                result = GenericResult.createInstance(user);
            }
            else {
                throw new UserException(ResultEnum.USER_NOT_FOUND_EXCEPTION);
            }
        } catch (DataIntegrityViolationException e) {
            logger.error("queryUserByUserName error",e);
            result = GenericResult.createInstance(ResultEnum.USER_EXISTS_EXCEPTION);
        } catch (SpecialException e) {
            logger.error("queryUserByUserName error", e);
            result = GenericResult.createInstance(e.getResultEnum());
        } catch (Exception e) {
            logger.error("queryUserByUserName error",e);
            result = GenericResult.createInstance(ResultEnum.ERROR);
        }
        return result;
    }

    @RequestMapping(value = "/createUser", method = {RequestMethod.POST})
    @ResponseStatus(value = HttpStatus.OK )
    public GenericResult<User> createUser(@RequestBody User user)
    {
        GenericResult<User> result;
        try {
            user = userService.saveUser(user);
            result = GenericResult.createInstance(user);
        } catch (DataIntegrityViolationException e) {
            logger.error("createUser error",e);
            result = GenericResult.createInstance(ResultEnum.USER_EXISTS_EXCEPTION);
        } catch (SpecialException e) {
            logger.error("createUser error", e);
            result = GenericResult.createInstance(e.getResultEnum());
        } catch (Exception e) {
            logger.error("createUser error",e);
            result = GenericResult.createInstance(ResultEnum.ERROR);
        }
        return result;
    }

    @RequestMapping(value = "/updateUser", method = {RequestMethod.POST})
    @ResponseStatus(value = HttpStatus.OK )
    public GenericResult<User> updateUser(@RequestBody User user)
    {
        GenericResult<User> result;
        try {
            Preconditions.checkNotNull(user,"request can not be empty");
            Preconditions.checkArgument(StringUtils.isNotBlank(user.getObjectId()),"user id cannot be empty");
            user = userService.findUserById(user.getObjectId());
            if(user == null) {
                throw new UserException(ResultEnum.USER_NOT_FOUND_EXCEPTION);
            }
            user = userService.saveUser(user);
            result = GenericResult.createInstance(user);
        } catch (DataIntegrityViolationException e) {
            logger.error("updateUser error",e);
            result = GenericResult.createInstance(ResultEnum.USER_EXISTS_EXCEPTION);
        } catch (SpecialException e) {
            logger.error("updateUser error", e);
            result = GenericResult.createInstance(e.getResultEnum());
        } catch (Exception e) {
            logger.error("updateUser error",e);
            result = GenericResult.createInstance(ResultEnum.ERROR);
        }
        return result;
    }

    @RequestMapping(value = "/deleteUser", method = {RequestMethod.DELETE})
    @ResponseStatus(value = HttpStatus.OK )
    public GenericResult deleteUser(String id) {
        GenericResult result;
        try {
            Preconditions.checkArgument(StringUtils.isNotBlank(id),"user id cannot be empty");
            User user = userService.findUserById(id);
            if(user == null) {
                throw new UserException(ResultEnum.USER_NOT_FOUND_EXCEPTION);
            }
            user.setDeleted(UUID.randomUUID().toString().toUpperCase());
            userService.saveUser(user);
            result = GenericResult.createInstance();
        } catch (DataIntegrityViolationException e) {
            logger.error("deleteUser error", e);
            result = GenericResult.createInstance(ResultEnum.USER_EXISTS_EXCEPTION);
        } catch (SpecialException e) {
            logger.error("deleteUser error", e);
            result = GenericResult.createInstance(e.getResultEnum());
        } catch (Exception e) {
            logger.error("deleteUser error", e);
            result = GenericResult.createInstance(ResultEnum.ERROR);
        }
        return result;
    }
}
