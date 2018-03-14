package exceptions;

public class ExampleException extends Exception {
    ExampleException(Exception e) {
        super(e);
    }

    public ExampleException() {
        this(new Exception());
    }
}
