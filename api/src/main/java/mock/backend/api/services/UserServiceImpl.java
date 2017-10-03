package mock.backend.api.services;

import lombok.Setter;
import mock.backend.api.dao.UserRepository;
import mock.backend.api.model.User;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Component(value = "userService")
public class UserServiceImpl extends BaseServiceImpl implements UserService
{
    @Setter
    @Resource(name = "userRepository")
    private UserRepository userRepository;

    @Override
    public User findUserByEmail(String email)
    {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public User findUserById(String id)
    {
        return userRepository.findUserById(id);
    }

    @Override
    public User findUserByUserName(String userName)
    {
        return this.userRepository.findUserByUserName(userName);
    }

    @Override
    @Transactional
    public User saveUser(User user)
    {
        User mergedUser = this.userRepository.save(user);
        return mergedUser;
    }
}
