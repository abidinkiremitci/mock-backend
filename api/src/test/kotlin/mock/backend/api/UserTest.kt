package mock.backend.api

import mock.backend.api.model.user.User
import mock.backend.api.services.user.UserService
import mock.backend.api.ws.user.model.CreateUserDTO
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit4.SpringRunner
import org.mockito.BDDMockito.given
import java.util.*

@RunWith(SpringRunner::class)
@SpringBootTest
class UserTest : BaseTest()
{
    @MockBean
    private val userService: UserService? = null

    @Test
    fun createUser() {
        val createUserDTO = CreateUserDTO()
        createUserDTO.age = 25
        createUserDTO.email = "semihunaldi@gmail.com"
        createUserDTO.firstName = "Semih"
        createUserDTO.lastName = "Unaldi"
        createUserDTO.ipAddress = "127.0.0.1"
        createUserDTO.location = "Istanbul/Turkey"
        createUserDTO.password = "password"
        createUserDTO.mobilePhone = "5331234567"
        createUserDTO.token = "token"
        createUserDTO.userName = "semihunaldi"
        val user = createUserDTO.createUserEntity()
        given<User>(userService!!.saveUser(user)).willReturn(prepareUser())
    }

    private fun prepareUser(): User {
        val user = User()
        user.age = 25
        user.email = "semihunaldi@gmail.com"
        user.firstName = "Semih"
        user.lastName ="Unaldi"
        user.setId(UUID.randomUUID().toString().toUpperCase())
        user.location = "Istanbul/Turkey"
        user.password = "password"
        user.mobilePhone = "5331234567"
        user.token = "token"
        user.userName = "semihunaldi"
        return user
    }
}