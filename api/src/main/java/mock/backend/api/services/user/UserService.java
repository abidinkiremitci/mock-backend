package mock.backend.api.services.user;


import mock.backend.api.model.user.User;
import mock.backend.api.services.BaseService;

/**
 * Created by semihunaldi on 09.09.2016.
 */
public interface UserService extends BaseService
{
    String testUser();

    User findUserByEmail(String email);

    User findUserById(String id);

    User findUserByUserName(String userName);

    User saveUser(User user);
}
