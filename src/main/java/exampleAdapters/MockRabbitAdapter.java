package exampleAdapters;

import java.io.IOException;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeoutException;

public class MockRabbitAdapter implements AbstractRabbitAdapter {
    private final String hostname;
    private final int port;

    public MockRabbitAdapter() {
        this("localhost", 5672);
    }

    public MockRabbitAdapter(String hostname) {
        this(hostname, 5672);
    }

    public MockRabbitAdapter(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
    }

    public void start() throws IOException, TimeoutException {
        if (!this.hostname.equals("localhost")) throw new UnknownHostException();
        if (this.port == 80) throw new TimeoutException();
        if (this.port != 5672) throw new ConnectException();
    }
}
