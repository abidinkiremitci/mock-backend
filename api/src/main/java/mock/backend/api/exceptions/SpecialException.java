package mock.backend.api.exceptions;

import lombok.Data;
import mock.backend.api.model.enums.ResultEnum;

@Data
public class SpecialException extends RuntimeException {

    private ResultEnum resultEnum;

    public SpecialException(ResultEnum resultEnum) {
        super(resultEnum.getDescription());
        this.resultEnum = resultEnum;
    }
}
