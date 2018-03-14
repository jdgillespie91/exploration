package exceptions;

import javax.ws.rs.WebApplicationException;

public class WebApplicationExceptionExample {
    public void main() throws ExampleException {
        try {
            throw new WebApplicationException(new RuntimeException());
        } catch (WebApplicationException e) {
            throw new ExampleException(e);
        }
    }
}
