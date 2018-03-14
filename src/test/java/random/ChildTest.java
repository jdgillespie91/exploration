package random;

import org.junit.Test;

import static org.junit.Assert.*;

public class ChildTest {
    @Test
    public void shouldReturnTrue() {
        Child child = new Child();
        assertTrue(child.stringsAreEqual());
    }

}