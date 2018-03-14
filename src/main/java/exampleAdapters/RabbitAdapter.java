package exampleAdapters;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RabbitAdapter implements AbstractRabbitAdapter {
    private final String hostname;
    private final int port;

    public RabbitAdapter() {
        this("localhost", 5672);
    }

    public RabbitAdapter(String hostname) {
        this(hostname, 5672);
    }

    public RabbitAdapter(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
    }

    public void start() throws IOException, TimeoutException {
        ConnectionFactory factory;
        Connection connection;
        Channel channel;

        factory = new ConnectionFactory();
        factory.setHost(this.hostname);
        factory.setPort(this.port);
        factory.setHandshakeTimeout(3000);

        connection = factory.newConnection();
        channel = connection.createChannel();

        channel.close();
        connection.close();
    }
}
