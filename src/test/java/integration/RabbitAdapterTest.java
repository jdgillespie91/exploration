package integration;

import exampleAdapters.AbstractRabbitAdapter;
import exampleAdapters.RabbitAdapter;

public class RabbitAdapterTest extends RabbitAdapterTestBase {
    @Override
    AbstractRabbitAdapter createAdapter() {
        return new RabbitAdapter();
    }

    @Override
    AbstractRabbitAdapter createAdapter(String hostname) {
        return new RabbitAdapter(hostname);
    }

    @Override
    AbstractRabbitAdapter createAdapter(String hostname, int port) {
        return new RabbitAdapter(hostname, port);
    }
}
