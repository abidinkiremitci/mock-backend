package mock.backend.api.services;


import mock.backend.api.model.User;

public interface UserService extends BaseService
{

    User findUserByEmail(String email);

    User findUserById(String id);

    User findUserByUserName(String userName);

    User saveUser(User user);
}
