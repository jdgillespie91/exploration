package integration;

import exampleAdapters.AbstractRabbitAdapter;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeoutException;

public abstract class RabbitAdapterTestBase {
    private AbstractRabbitAdapter adapter;

    abstract AbstractRabbitAdapter createAdapter();
    abstract AbstractRabbitAdapter createAdapter(String hostname);
    abstract AbstractRabbitAdapter createAdapter(String hostname, int port);

    @Before
    public void setup() {
        adapter = createAdapter();
    }

    @Test
    public void testCanStart() throws IOException, TimeoutException {
        adapter.start();
    }

    @Test(expected = UnknownHostException.class)
    public void testStartThrowsIfHostCannotBeReached() throws IOException, TimeoutException {
        createAdapter("badhost").start();
    }

    @Test(expected = ConnectException.class)
    public void testStartThrowsIfConnectionRefused() throws IOException, TimeoutException {
        createAdapter("localhost", 5673).start();
    }

    @Test(expected = TimeoutException.class)
    public void testStartThrowsIfRabbitNotOnPort() throws IOException, TimeoutException {
        createAdapter("localhost", 80).start();
    }
}
