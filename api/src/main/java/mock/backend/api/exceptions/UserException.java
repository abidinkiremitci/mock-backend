package mock.backend.api.exceptions;


import mock.backend.api.model.enums.ResultEnum;

public class UserException extends SpecialException {

    public UserException(ResultEnum resultEnum) {
        super(resultEnum);
    }
}