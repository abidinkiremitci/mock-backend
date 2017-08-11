package mock.backend.api.ws;

import lombok.Data;

/**
 * Created by semihunaldi on 5.4.2015.
 */

@Data
public class BaseResult
{
    private Integer errorCode = 0 ;

    private String errorDescription = "Success";

    public BaseResult(Integer errorCode, String errorDescription)
    {
        this.errorCode = errorCode;
        this.errorDescription = errorDescription;
    }

    public BaseResult()
    {
    }
}
