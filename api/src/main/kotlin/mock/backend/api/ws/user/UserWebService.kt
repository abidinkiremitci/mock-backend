package mock.backend.api.ws.user

import mock.backend.api.ws.user.model.CreateUserDTO
import mock.backend.api.ws.user.model.UserDTO
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RequestMapping(path = arrayOf("/api"))
interface UserWebService
{
    @RequestMapping(value = "/user/queryUserByEmail", method = arrayOf(RequestMethod.GET))
    abstract //http://localhost:8080/api/user/queryUserByEmail?email=test@test.com
    fun queryUserByEmail(@RequestParam(value = "email", defaultValue = "") email: String): UserDTO

    @RequestMapping(value = "/user/queryUserById", method = arrayOf(RequestMethod.GET))
    abstract //http://localhost:8080/api/user/queryUserById?id=
    fun queryUserById(@RequestParam(value = "id", defaultValue = "") id: String): UserDTO

    @RequestMapping(value = "/user/queryUserByUserName", method = arrayOf(RequestMethod.GET))
    abstract //http://localhost:8080/api/user/queryUserByUserName?userName=
    fun queryUserByUserName(@RequestParam(value = "userName", defaultValue = "") userName: String): UserDTO

    @RequestMapping(value = "/user/createUser", method = arrayOf(RequestMethod.POST))
    @ResponseStatus(value = HttpStatus.OK)
    abstract //http://localhost:8080/api/user/createUser
    fun createUser(@RequestBody createUserDTO: CreateUserDTO): CreateUserDTO

    @RequestMapping(value = "/user/updateUser", method = arrayOf(RequestMethod.POST))
    @ResponseStatus(value = HttpStatus.OK)
    abstract //http://localhost:8080/api/user/updateUser
    fun updateUser(@RequestBody createUserDTO: CreateUserDTO): CreateUserDTO
}