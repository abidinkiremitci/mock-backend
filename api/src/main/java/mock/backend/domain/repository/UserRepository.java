package mock.backend.domain.repository;

import mock.backend.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String>
{
    User findByEmail(String email);
    User findByUserName(String userName);
}
