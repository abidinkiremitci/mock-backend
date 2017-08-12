package mock.backend.api.ws.user.model

import mock.backend.api.enums.SpecialExceptions
import mock.backend.api.model.user.User
import mock.backend.api.ws.BaseResult


class UserDTO : BaseResult
{
    var id: String? = null

    var firstName: String? = null

    var lastName: String? = null

    var userName: String? = null

    var email: String? = null

    constructor()
    {

    }

    constructor(errorCode: Int, errorDescription: String?) : super(errorCode, errorDescription)

    constructor(specialExceptions: SpecialExceptions) : super(specialExceptions.errorCode, specialExceptions.errorDescription)

    companion object
    {
        fun create(user: User): UserDTO {
            val userDTO = UserDTO()
            userDTO.id = user.getId()
            userDTO.firstName = user.firstName
            userDTO.lastName = user.lastName
            userDTO.userName = user.userName
            userDTO.email = user.email
            return userDTO
        }
    }

}