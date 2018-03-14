package unit.exceptions;

import exceptions.ExampleException;
import exceptions.WebApplicationExceptionExample;
import org.junit.Test;

import javax.ws.rs.WebApplicationException;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

public class WebApplicationExceptionExampleTest {
    @Test
    public void mainShouldThrowWrappedException() {
        try {
            new WebApplicationExceptionExample().main();
        } catch (ExampleException e) {
            assertThat(e.getCause(), instanceOf(WebApplicationException.class));
            assertThat(e.getCause().getCause(), instanceOf(RuntimeException.class));
        }
    }
}