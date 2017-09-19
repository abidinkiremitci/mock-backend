package mock.backend.api.ws.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by semihunaldi on 23.08.2016.
 */

@RequestMapping(path = "/api")
public interface UserWebService
{
    @RequestMapping(value = "/user/queryUserByEmail", method = {RequestMethod.GET})
    //http://localhost:8080/api/user/queryUserByEmail?email=test@test.com
    public UserDTO queryUserByEmail(@RequestParam(value = "email", defaultValue = "") String email);

    @RequestMapping(value = "/user/queryUserById", method = {RequestMethod.GET})
    //http://localhost:8080/api/user/queryUserById?id=
    public UserDTO queryUserById(@RequestParam(value = "id", defaultValue = "") String id);

    @RequestMapping(value = "/user/queryUserByUserName", method = {RequestMethod.GET})
    //http://localhost:8080/api/user/queryUserByUserName?userName=
    public UserDTO queryUserByUserName(@RequestParam(value = "userName", defaultValue = "") String userName);

    @RequestMapping(value = "/user/createUser", method = {RequestMethod.POST})
    @ResponseStatus(value = HttpStatus.OK )
    //http://localhost:8080/api/user/createUser
    public CreateUserDTO createUser(@RequestBody CreateUserDTO createUserDTO);

    @RequestMapping(value = "/user/updateUser", method = {RequestMethod.POST})
    @ResponseStatus(value = HttpStatus.OK )
    //http://localhost:8080/api/user/updateUser
    public CreateUserDTO updateUser(@RequestBody CreateUserDTO createUserDTO);
}
