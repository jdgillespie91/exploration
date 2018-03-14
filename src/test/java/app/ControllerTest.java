package app;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class ControllerTest {
    @Test
    public void mainReturnsResponseWhenHelloGoodbyeServiceIsUp() {
        List<String> expectedResponses = new ArrayList<>();
        expectedResponses.add("You say \"Yes\"");
        expectedResponses.add("I say \"No\"");
        expectedResponses.add("You say \"Stop\"");
        expectedResponses.add("I say \"Go, go, go!\"");

        String actualResponse = Controller.main();

        assertThat(expectedResponses.contains(actualResponse), is(true));
    }

    @Test
    public void mainReturnsNullWhenHelloGoodbyeServiceIsDown() {
        assertNull(Controller.main());
    }
}