package json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class ObjectMapperExample {
    public static Car main() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String json = "{\"brand\": \"mercedes\", \"doors\": 5}";
        return mapper.readValue(json, Car.class);
    }
}
