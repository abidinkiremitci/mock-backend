package mock.backend.api.services.user.impl

import com.semihunaldi.kotlin.springbootkotlintest.services.BaseServiceImpl
import mock.backend.api.services.user.UserService
import lombok.Setter
import mock.backend.api.dao.user.UserRepository
import mock.backend.api.model.user.User
import org.springframework.stereotype.Component
import javax.annotation.Resource
import javax.transaction.Transactional

@Component("userService")
class UserServiceImpl : BaseServiceImpl(), UserService
{
    @Setter
    @Resource(name = "userRepository")
    private val userRepository: UserRepository? = null

    override fun testUser(): String {
        val userList = userRepository!!.findAllUsers()
        return "Test"
    }

    override fun findUserByEmail(email: String): User? {
        return userRepository!!.findUserByEmail(email)
    }

    override fun findUserById(id: String): User? {
        return userRepository!!.findUserById(id)
    }

    override fun findUserByUserName(userName: String): User? {
        return this.userRepository!!.findUserByUserName(userName)
    }

    @Transactional
    override fun saveUser(user: User?): User? {
        val mergedUser = this.userRepository!!.save(user)
        return mergedUser
    }
}