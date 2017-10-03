package mock.backend.api;

import mock.backend.api.model.User;
import mock.backend.api.services.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest extends BaseTest
{
    @MockBean
    private UserService userService;

    @Test
    public void createUser()
    {
        User user = new User();
        user.setAge(25);
        user.setEmail("semihunaldi@gmail.com");
        user.setFirstName("Semih");
        user.setLastName("Unaldi");
        user.setLocation("Istanbul/Turkey");
        user.setMobilePhone("5331234567");
        user.setUserName("semihunaldi");
        //TODO: check entity equality more elegant way
    }
}
