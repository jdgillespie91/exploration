package techCongress.mock;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class DelegateTest {
    private Service service;
    private Delegate delegate;

    @Before
    public void setup() {
        service = mock(Service.class);
        delegate = new Delegate(service);
    }

    @Test
    public void canCreateApplication() {
        delegate.createApplication();
    }

    @Test
    public void createApplicationCallsDelegate() {
        delegate.createApplication();
        verify(service).createApplication();
    }
}