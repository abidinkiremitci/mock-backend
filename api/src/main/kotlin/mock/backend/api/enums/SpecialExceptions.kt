package mock.backend.api.enums

enum class SpecialExceptions(var errorCode : Int, var errorDescription: String)
{
    USER_NOT_FOUND_EXCEPTION(1, "User not found"),
    USER_EXISTS_EXCEPTION(2, "User exists with given data"),
    ERROR(99, "Error");
}