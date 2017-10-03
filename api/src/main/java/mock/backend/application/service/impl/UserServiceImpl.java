package mock.backend.application.service.impl;

import lombok.Setter;
import mock.backend.application.service.UserService;
import mock.backend.domain.model.User;
import mock.backend.domain.repository.UserRepository;
import mock.backend.infra.exception.UserNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component(value = "userService")
public class UserServiceImpl extends BaseServiceImpl implements UserService
{
    @Setter
    @Resource(name = "userRepository")
    private UserRepository userRepository;

    @Override
    public User findUserByEmail(final String email)
    {
        return Optional.ofNullable(userRepository.findByEmail(email))
                .orElseThrow(() -> new UserNotFoundException(String.format("User not found with given email: %s", email)));
    }

    @Override
    public User findUserById(final String id)
    {
        return Optional.ofNullable(getOne(id))
                .orElseThrow(() -> new UserNotFoundException(String.format("User not found with given id: %s", id)));
    }

    private User getOne(String id) {
        return userRepository.findOne(id);
    }

    @Override
    public User findUserByUserName(final String userName)
    {
        return Optional.ofNullable(this.userRepository.findByUserName(userName))
                .orElseThrow(() -> new UserNotFoundException(String.format("User not found with given email: %s", userName)));
    }

    @Override
    public List<User> findAll(){
        return Optional.ofNullable(this.userRepository.findAll())
                .orElseThrow(() -> new UserNotFoundException(String.format("There is no user data")));
    }

    @Override
    public Page<User> findAll(Pageable pageable){
        return Optional.ofNullable(this.userRepository.findAll(pageable))
                .orElseThrow(() -> new UserNotFoundException(String.format("There is no user data for pagination")));
    }

    @Override
    @Transactional
    public User save(User user)
    {
        return this.userRepository.save(user);
    }

    @Override
    public User update(final String id, final User newUser) {
        Optional<User> oldUser = Optional.ofNullable(getOne(id));
        if(!oldUser.isPresent()) {
            throw new UserNotFoundException(String.format("User not found with given id: %s", id));
        }
        return updateUser(oldUser.get(), newUser);
    }

    @Override
    public void delete(String id) {
        Optional.ofNullable(getOne(id))
                .ifPresent(r -> {
                    r.setDeleted(UUID.randomUUID().toString().toUpperCase());
                    userRepository.save(r);
                });
    }

    private User updateUser(User oldUser, User newUser) {
        User toBeUpdated = User.builder()
                .objectId(newUser.getId())
                .firstName(newUser.getFirstName())
                .lastName(newUser.getLastName())
                .userName(newUser.getUserName())
                .email(newUser.getEmail())
                .mobilePhone(newUser.getMobilePhone())
                .age(newUser.getAge())
                .location(newUser.getLocation())
                .timeZone(newUser.getTimeZone())
                .build();
        toBeUpdated.setId(oldUser.getId());
        toBeUpdated.setActive(oldUser.getActive());
        toBeUpdated.setCreateTime(oldUser.getCreateTime());
        toBeUpdated.setUpdateTime(oldUser.getUpdateTime());
        toBeUpdated.setDeleted(oldUser.getDeleted());
        return save(toBeUpdated);

    }
}
