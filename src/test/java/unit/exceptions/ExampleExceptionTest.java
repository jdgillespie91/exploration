package unit.exceptions;

import exceptions.ExampleException;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

public class ExampleExceptionTest {
    @Test
    public void exampleExceptionShouldSubclassException() {
        ExampleException exampleException = new ExampleException();
        assertThat(exampleException, instanceOf(Exception.class));
    }

    @Test(expected = IOException.class)
    public void checkedExceptionShouldBeChecked() throws IOException {
        throw new IOException();
    }

    @Test(expected = RuntimeException.class)
    public void uncheckedExceptionShouldBeUnchecked() {
        throw new RuntimeException();
    }
}