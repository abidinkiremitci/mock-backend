package mock.backend.api.ws

import com.google.common.collect.Lists
import com.google.gson.Gson
import mock.backend.api.config.properties.AppProperties
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.validation.BindingResult
import org.springframework.validation.ObjectError

abstract class BaseRestController
{
    protected val logger = LoggerFactory.getLogger(this.javaClass)

    @Autowired
    protected var appProperties: AppProperties? = null

    fun isValidationPassed(bindingResult: BindingResult) {
        if (bindingResult.hasErrors()) {
            throw IllegalArgumentException(prepareErrorMessages(bindingResult.allErrors).toString())
        }
    }

    private fun prepareErrorMessages(objectErrorList: List<ObjectError>): List<String> {
        val errorList = Lists.newArrayList<String>()
        for (objectError in objectErrorList) {
            errorList.add(objectError.defaultMessage)
        }
        return errorList
    }

    fun getJsonString(o: Any): String {
        val gson = Gson()
        return gson.toJson(o)
    }
}