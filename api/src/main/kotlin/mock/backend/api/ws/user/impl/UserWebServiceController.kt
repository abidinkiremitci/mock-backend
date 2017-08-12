package mock.backend.api.ws.user.impl

import com.google.common.base.Preconditions
import lombok.Setter
import mock.backend.api.enums.SpecialExceptions
import mock.backend.api.exceptions.UserException
import mock.backend.api.model.user.User
import mock.backend.api.services.user.UserService
import mock.backend.api.ws.BaseRestController
import mock.backend.api.ws.user.UserWebService
import mock.backend.api.ws.user.model.CreateUserDTO
import mock.backend.api.ws.user.model.UserDTO
import org.apache.commons.lang.StringUtils
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.web.bind.annotation.*
import javax.annotation.Resource

@RestController
class UserWebServiceController : BaseRestController() , UserWebService
{
    @Setter
    @Resource(name = "userService")
    private val userService: UserService? = null

    override fun queryUserByEmail(@RequestParam(value = "email", defaultValue = "") email: String): UserDTO {
        try {
            val user = userService?.findUserByEmail(email)
            if (user != null) {
                return UserDTO.create(user)
            } else {
                throw UserException(SpecialExceptions.USER_NOT_FOUND_EXCEPTION, SpecialExceptions.USER_NOT_FOUND_EXCEPTION.errorCode)
            }
        } catch (e: UserException) {
            logger.error("queryUserByEmail error", e)
            return UserDTO(e.errorCode, e.message)
        } catch (e: Exception) {
            logger.error("queryUserByEmail error", e)
            return UserDTO(SpecialExceptions.ERROR)
        }

    }

    override fun queryUserById(@RequestParam(value = "id", defaultValue = "") id: String): UserDTO {
        try {
            val user = userService?.findUserById(id)
            if (user != null) {
                return UserDTO.create(user)
            } else {
                throw UserException(SpecialExceptions.USER_NOT_FOUND_EXCEPTION, SpecialExceptions.USER_NOT_FOUND_EXCEPTION.errorCode)
            }
        } catch (e: UserException) {
            logger.error("queryUserById error", e)
            return UserDTO(e.errorCode, e.errorDescription.errorDescription)
        } catch (e: Exception) {
            logger.error("queryUserById error", e)
            return UserDTO(SpecialExceptions.ERROR)
        }

    }

    override fun queryUserByUserName(@RequestParam(value = "userName", defaultValue = "") userName: String): UserDTO {
        try {
            val user = userService?.findUserByUserName(userName)
            if (user != null) {
                return UserDTO.create(user)
            } else {
                throw UserException(SpecialExceptions.USER_NOT_FOUND_EXCEPTION, SpecialExceptions.USER_NOT_FOUND_EXCEPTION.errorCode)
            }
        } catch (e: UserException) {
            logger.error("queryUserByUserName error", e)
            return UserDTO(e.errorCode, e.errorDescription.errorDescription)
        } catch (e: Exception) {
            logger.error("queryUserByUserName error", e)
            return UserDTO(SpecialExceptions.ERROR)
        }

    }

    override fun createUser(@RequestBody createUserDTO: CreateUserDTO): CreateUserDTO {
        try {
            var user : User? = createUserDTO.createUserEntity()
            user = userService?.saveUser(user)
            return CreateUserDTO.createCreateUserDTO(user!!)
        } catch (e: DataIntegrityViolationException) {
            logger.error("createUser error", e)
            val userException = UserException(SpecialExceptions.USER_EXISTS_EXCEPTION, SpecialExceptions.USER_EXISTS_EXCEPTION.errorCode)
            return CreateUserDTO(userException.errorCode, userException.errorDescription.errorDescription)
        } catch (e: Exception) {
            logger.error("createUser error", e)
            return CreateUserDTO(SpecialExceptions.ERROR)
        }

    }

    override fun updateUser(@RequestBody createUserDTO: CreateUserDTO): CreateUserDTO {
        try {
            Preconditions.checkNotNull(createUserDTO, "request can not be empty")
            Preconditions.checkArgument(StringUtils.isNotBlank(createUserDTO.userId), "user id cannot be empty")
            var user: User? = userService?.findUserById(createUserDTO.userId!!) ?: throw UserException(SpecialExceptions.USER_NOT_FOUND_EXCEPTION, SpecialExceptions.USER_NOT_FOUND_EXCEPTION.errorCode)
            CreateUserDTO.updateUserEntityFields(user!!, createUserDTO)
            user = userService.saveUser(user)
            return CreateUserDTO.createCreateUserDTO(user!!)
        } catch (e: DataIntegrityViolationException) {
            logger.error("updateUser error", e)
            val userException = UserException(SpecialExceptions.USER_EXISTS_EXCEPTION, SpecialExceptions.USER_EXISTS_EXCEPTION.errorCode)
            return CreateUserDTO(userException.errorCode, userException.errorDescription.errorDescription)
        } catch (e: Exception) {
            logger.error("updateUser error", e)
            return CreateUserDTO(SpecialExceptions.ERROR)
        }

    }
}