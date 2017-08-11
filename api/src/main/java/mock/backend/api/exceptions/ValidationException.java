package mock.backend.api.exceptions;

public class ValidationException extends RuntimeException
{
    public ValidationException(String message)
    {
        super(message);
    }
}
