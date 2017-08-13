package mock.backend.api.ws;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import mock.backend.api.config.properties.AppProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.List;

/**
 * Created by semihunaldi on 18.8.2015.
 */
public abstract class BaseRestController
{
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    protected AppProperties appProperties;

    public void isValidationPassed(BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            throw new IllegalArgumentException(prepareErrorMessages(bindingResult.getAllErrors()).toString());
        }
    }

    private List<String> prepareErrorMessages(List<ObjectError> objectErrorList)
    {
        List<String> errorList = Lists.newArrayList();
        for(ObjectError objectError: objectErrorList)
        {
            errorList.add(objectError.getDefaultMessage());
        }
        return errorList;
    }

    public String getJsonString(Object o)
    {
        Gson gson = new Gson();
        return gson.toJson(o);
    }
}