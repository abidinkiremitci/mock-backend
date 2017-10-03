package mock.backend.api;

import mock.backend.domain.model.User;
import mock.backend.application.service.UserService;
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
        User user = User.builder()
                .age(25)
                .email("semihunaldi@gmail.com")
                .firstName("Semih")
                .lastName("Unaldi")
                .location("Istanbul/Turkey")
                .mobilePhone("5331234567")
                .userName("semihunaldi")
                .build();
        //TODO: check entity equality more elegant way
    }
}
