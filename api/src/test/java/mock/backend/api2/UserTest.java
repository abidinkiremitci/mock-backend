package mock.backend.api2;

import mock.backend.api.model.user.User;
import mock.backend.api.services.user.UserService;
import mock.backend.api.ws.user.CreateUserDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

import static org.mockito.BDDMockito.given;

/**
 * Created by semihunaldi on 3.04.2017.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest extends BaseTest
{
    @MockBean
    private UserService userService;

    @Test
    public void createUser()
    {
        CreateUserDTO createUserDTO = new CreateUserDTO();
        createUserDTO.setAge(25);
        createUserDTO.setEmail("semihunaldi@gmail.com");
        createUserDTO.setFirstName("Semih");
        createUserDTO.setLastName("Unaldi");
        createUserDTO.setIpAddress("127.0.0.1");
        createUserDTO.setLocation("Istanbul/Turkey");
        createUserDTO.setPassword("password");
        createUserDTO.setMobilePhone("5331234567");
        createUserDTO.setToken("token");
        createUserDTO.setUserName("semihunaldi");
        User user = createUserDTO.createUserEntity();
        given(userService.saveUser(user)).willReturn(prepareUser());
    }

    private User prepareUser()
    {
        User user = new User();
        user.setAge(25);
        user.setEmail("semihunaldi@gmail.com");
        user.setFirstName("Semih");
        user.setLastName("Unaldi");
        user.setCreateUserIP("127.0.0.1");
        user.setUpdateUserIP("127.0.0.1");
        user.setId(UUID.randomUUID().toString().toUpperCase());
        user.setLocation("Istanbul/Turkey");
        user.setPassword("password");
        user.setMobilePhone("5331234567");
        user.setToken("token");
        user.setUserName("semihunaldi");
        return user;
    }

}
