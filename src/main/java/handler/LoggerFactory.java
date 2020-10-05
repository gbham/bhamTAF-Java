package handler;


import java.io.IOException;
import java.io.InputStream;
import java.util.logging.*;


public class LoggerFactory
{
    public static void InitialiseLogger() throws IOException
    {
        InputStream stream = LoggerFactory.class.getClassLoader().getResourceAsStream("logger.properties");

        LogManager.getLogManager().readConfiguration(stream);
    }

    private static LoggerFactory instance = new LoggerFactory();

    public static LoggerFactory getInstance()
    {
        return instance;
    }

    ThreadLocal<Logger> LOG = ThreadLocal.withInitial(() ->
    {
        Logger logger = Logger.getLogger(TestMethodCapture.getTestMethod().getMethodName());
        FileHandler handler;

        try {
            handler = new FileHandler("TestResults\\Logs\\" + TestMethodCapture.getTestMethod().getMethodName(), true);
            logger.addHandler(handler);
            logger.info("Logger Initialised");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return logger;
    });

    public Logger getLogger()
    {
        return LOG.get();
    }

    public void removeLogger()
    {
        for(Handler h: LOG.get().getHandlers())
        {
            h.close();
        }

        LOG.remove();
    }
}
