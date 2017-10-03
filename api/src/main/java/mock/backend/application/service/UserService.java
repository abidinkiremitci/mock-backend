package mock.backend.application.service;


import mock.backend.domain.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService extends BaseService
{

    User findUserByEmail(String email);

    User findUserById(String id);

    User findUserByUserName(String userName);

    List<User> findAll();

    Page<User> findAll(Pageable pageable);

    User save(User user);

    User update(String id, User user);

    void delete(String id);
}
