package mock.backend.api.ws;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import mock.backend.api.model.enums.ResultEnum;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GenericResult<T> {
    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.WRAPPER_OBJECT)

    T body;
    Result result;

    public GenericResult(T body, Result result) {
        this.result = result;
        this.body = body;
    }

    public GenericResult(){
        this.result = new Result();
    }

    public static GenericResult createInstance() {
        return new GenericResult();
    }

    public static GenericResult createInstance(ResultEnum resultEnum) {
        GenericResult genericResult = createInstance();
        genericResult.setBody(null);
        genericResult.setResult(Result.createInstance(resultEnum));
        return genericResult;
    }

    public static GenericResult createInstance(Object object) {
        GenericResult genericResult = createInstance();
        genericResult.setBody(object);
        genericResult.setResult(Result.createInstance(ResultEnum.SUCCESS));
        return genericResult;
    }
}
