package mock.backend.api.services.user

import com.semihunaldi.kotlin.springbootkotlintest.services.BaseService
import mock.backend.api.model.user.User


interface UserService : BaseService
{
    abstract fun testUser(): String?

    abstract fun findUserByEmail(email: String): User?

    abstract fun findUserById(id: String): User?

    abstract fun findUserByUserName(userName: String): User?

    abstract fun saveUser(user: User?): User?
}