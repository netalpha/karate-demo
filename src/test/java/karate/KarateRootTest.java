package karate;

import com.intuit.karate.junit4.Karate;
import karate.test.ServerStart;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Karate.class)
public abstract class KarateRootTest {

    private static ServerStart server;

    public static int startServer() throws Exception {
        if (server == null) { // keep spring boot side alive for all tests including package 'mock'
            server = new ServerStart();
            server.start(new String[]{"--server.port=8080"}, false);
        }
        System.setProperty("demo.server.port", 8080 + "");
        return server.getPort();
    }

    @BeforeClass
    public static void beforeClass() throws Exception {
        System.setProperty("karate.env", "dev");
        startServer();
    }
}
