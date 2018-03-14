package exceptions;

import java.io.IOException;

public class NestedExceptionExample {
    public void main() throws ExampleException {
        try {
            throw new IOException();
        } catch (IOException e) {
            throw new ExampleException(e);
        }
    }
}
