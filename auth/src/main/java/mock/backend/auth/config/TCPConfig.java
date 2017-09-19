package mock.backend.auth.config;

import lombok.Setter;
import org.h2.tools.Server;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.SQLException;

@Component
public class TCPConfig
{

    @Setter
    @Value("${app.properties.environment}")
    private String environment;

    private Server server = null;

    protected final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostConstruct
    public void init()
    {
        if (String.valueOf("dev").equals(environment)) {
            try
            {
                server = Server.createTcpServer().start();
            }
            catch (SQLException e)
            {
                logger.error("createTcpServer error", e);
            }
        }
    }


    @PreDestroy
    public void destroy() throws Exception
    {
        if(String.valueOf("dev").equals(environment) && server != null)
        {
            server.stop();
        }
    }
}