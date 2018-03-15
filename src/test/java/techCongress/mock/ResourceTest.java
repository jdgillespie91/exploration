package techCongress.mock;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ResourceTest {
    private Delegate delegate;
    private Resource resource;

    @Before
    public void setup() {
        delegate = mock(Delegate.class);
        resource = new Resource(delegate);
    }

    @Test
    public void canCreateApplication() {
        resource.createApplication();
    }

    @Test
    public void createApplicationCallsDelegate() {
        resource.createApplication();
        verify(delegate).createApplication();
    }

    @Test
    public void createApplicationWithTypeCallsDelegateWithType() {
        resource.createApplication("PGD");
        verify(delegate).createApplication("PGD");
    }
}