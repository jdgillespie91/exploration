package random;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertFalse;

public class OptionalsTest {
    @Test
    public void testMain() {
        Optional<String> main = Optionals.main();
        assertFalse(main.isPresent());
    }

}