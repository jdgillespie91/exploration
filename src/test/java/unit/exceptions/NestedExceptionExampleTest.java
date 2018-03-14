package unit.exceptions;

import exceptions.ExampleException;
import exceptions.NestedExceptionExample;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

public class NestedExceptionExampleTest {
    @Test
    public void mainShouldThrowExampleException() {
        try {
            new NestedExceptionExample().main();
        } catch (ExampleException e) {
            assertThat(e.getCause(), instanceOf(IOException.class));
        }
    }
}