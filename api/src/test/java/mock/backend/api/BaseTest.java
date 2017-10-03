package mock.backend.api;

public class BaseTest
{
    static
    {
        if(System.getProperty("spring.config.name") == null)
        {
            System.setProperty("spring.config.name", "application.dev");
        }
    }
}
