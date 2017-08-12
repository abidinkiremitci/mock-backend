package mock.backend.api

open class BaseTest
{
    init {
        if(System.getProperty("spring.config.name") == null)
        {
            System.setProperty("spring.config.name", "application.dev");
        }
    }
}