package mock.backend.api.config;

import mock.backend.api.config.properties.AppProperties;
import org.h2.tools.Server;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.SQLException;

@Component
public class TCPConfig
{

    @Autowired
    private AppProperties appProperties;

    private Server server = null;

    protected final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostConstruct
    public void init()
    {
        try
        {
            if(appProperties.getEnvironment().equals("development"))
            {
                server = org.h2.tools.Server.createTcpServer().start();
            }
        }
        catch (SQLException e)
        {
            logger.error("createTcpServer error", e);
        }
    }


    @PreDestroy
    public void destroy() throws Exception
    {
        if(server != null)
        {
            server.stop();
        }
    }
}
