package exampleAdapters;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public interface AbstractRabbitAdapter {
    void start() throws IOException, TimeoutException;
}
