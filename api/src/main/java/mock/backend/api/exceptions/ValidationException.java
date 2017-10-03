package mock.backend.api.exceptions;

import mock.backend.api.model.enums.ResultEnum;

public class ValidationException extends SpecialException {

    public ValidationException(ResultEnum resultEnum) {
        super(resultEnum);
    }
}
