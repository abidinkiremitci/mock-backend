package mock.backend.api.dao.user;

import mock.backend.api.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by semihunaldi on 11.09.2016.
 */

@Repository
public interface UserRepository extends JpaRepository<User, String>
{
    @Query("select user from User user")
    public List<User> findAllUsers();

    @Query("select user from User user where user.email=:email")
    public User findUserByEmail(@Param("email") String email);

    @Query("select user from User user where user.id=:id ")
    public User findUserById(@Param("id") String id);

    @Query("select user from User user where user.userName=:userName")
    public User findUserByUserName(@Param("userName") String userName);

}
