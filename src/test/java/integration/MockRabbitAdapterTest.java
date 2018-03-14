package integration;

import exampleAdapters.AbstractRabbitAdapter;
import exampleAdapters.MockRabbitAdapter;

public class MockRabbitAdapterTest extends RabbitAdapterTestBase {
    @Override
    AbstractRabbitAdapter createAdapter() {
        return new MockRabbitAdapter();
    }

    @Override
    AbstractRabbitAdapter createAdapter(String hostname) {
        return new MockRabbitAdapter(hostname);
    }

    @Override
    AbstractRabbitAdapter createAdapter(String hostname, int port) {
        return new MockRabbitAdapter(hostname, port);
    }
}
