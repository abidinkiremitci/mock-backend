package mock.backend.api.ws.user.model

import mock.backend.api.enums.SpecialExceptions
import mock.backend.api.model.user.User
import mock.backend.api.ws.BaseResult
import org.apache.commons.lang.StringUtils

class CreateUserDTO : BaseResult
{
    constructor()
    {

    }

    constructor(errorCode: Int, errorDescription: String?) : super(errorCode, errorDescription)

    constructor(specialExceptions: SpecialExceptions) : super(specialExceptions.errorCode, specialExceptions.errorDescription)


    var userId: String? = null

    var password: String? = null

    var firstName: String? = null

    var lastName: String? = null

    var userName: String? = null

    var email: String? = null

    var mobilePhone: String? = null

    var token: String? = null

    var age: Int? = null

    var location: String? = null

    var ipAddress: String? = null


    fun createUserEntity(): User {
        val user = User()
        setUserCommonFields(user, this)
        user.password = this.password
        return user
    }

    companion object {

        fun updateUserEntityFields(user: User, createUserDTO: CreateUserDTO) {
            setUserCommonFields(user, createUserDTO)
        }

        fun createCreateUserDTO(user: User): CreateUserDTO {
            val createUserDTO = CreateUserDTO()
            createUserDTO.firstName = user.firstName
            createUserDTO.lastName = user.lastName
            createUserDTO.userName = user.userName
            createUserDTO.email = user.email
            createUserDTO.mobilePhone = user.mobilePhone
            createUserDTO.age = user.age
            createUserDTO.location = user.location
            createUserDTO.token = user.token
            createUserDTO.password = user.password
            createUserDTO.ipAddress = user.password
            return createUserDTO
        }
        private fun setUserCommonFields(user: User, createUserDTO: CreateUserDTO) {
            user.firstName = createUserDTO.firstName
            user.lastName = createUserDTO.lastName
            user.userName = createUserDTO.userName
            user.email = createUserDTO.email
            user.mobilePhone = createUserDTO.mobilePhone
            user.age = createUserDTO.age
            user.password = createUserDTO.password
            user.location = createUserDTO.location
            user.token = createUserDTO.token
            if (StringUtils.isNotBlank(createUserDTO.userId)) {
                user.setId(createUserDTO.userId)
            }
        }
    }


}