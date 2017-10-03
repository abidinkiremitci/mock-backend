package mock.backend.api.model.enums;

public enum ResultEnum {
    SUCCESS(0,"Success"),
    USER_NOT_FOUND_EXCEPTION(1,"User not found"),
    USER_EXISTS_EXCEPTION(2,"User exists with given data"),
    ERROR(99,"Error");

    private Integer code;

    private String description;

    ResultEnum(Integer code, String description)
    {
        this.code = code;
        this.description = description;
    }

    public Integer getCode()
    {
        return code;
    }

    public String getDescription()
    {
        return description;
    }

}
