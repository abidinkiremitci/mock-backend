package mock.backend.api.ws

open class BaseResult
{
    private var errorCode = 0

    private var errorDescription : String? = "Success"

    constructor(errorCode: Int, errorDescription: String?) {
        this.errorCode = errorCode
        this.errorDescription = errorDescription
    }

    constructor() {}
}