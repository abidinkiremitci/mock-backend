package mock.backend.api.exceptions

import mock.backend.api.enums.SpecialExceptions

class UserException(var errorDescription: SpecialExceptions, var errorCode: Int) : RuntimeException(errorDescription.errorDescription)
{
}