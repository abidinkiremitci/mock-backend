package mock.backend.api2;

/**
 * Created by semihunaldi on 15.11.2016.
 */
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
