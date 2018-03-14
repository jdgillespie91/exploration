package json;

import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

public class ObjectMapperExampleTest {
    @Test
    public void shouldReturnCar() throws IOException {
        assertThat(ObjectMapperExample.main(), instanceOf(Car.class));
    }

    @Test
    public void carHasCorrectAttributes() throws IOException {
        Car car = ObjectMapperExample.main();
        assertEquals("mercedes", car.getBrand());
        assertEquals(5, car.getDoors());
    }
}