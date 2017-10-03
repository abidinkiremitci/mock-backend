package mock.backend.api.ws;

import lombok.Data;
import mock.backend.api.model.enums.ResultEnum;

@Data
public class Result {
    private Integer code;
    private String description;

    public Result() {
        this.code = ResultEnum.SUCCESS.getCode();
        this.description =  ResultEnum.SUCCESS.getDescription();
    }

    public Result(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public static Result createInstance() {
        return new Result();
    }

    public static Result createInstance(Integer errorCode, String errorDescription) {
        return new Result(errorCode,errorDescription);
    }

    public static Result createInstance(ResultEnum resultEnum) {
        return new Result(resultEnum.getCode(), resultEnum.getDescription());
    }
}
