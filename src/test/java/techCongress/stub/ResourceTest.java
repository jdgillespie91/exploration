package techCongress.stub;

import org.junit.Before;
import org.junit.Test;

public class ResourceTest {
    private Resource resource;

    @Before
    public void setup() {
        StubApplicationRepository applicationRepository = new StubApplicationRepository();
        StubEventRepository eventRepository = new StubEventRepository();
        resource = new Resource(applicationRepository, eventRepository);
    }

    @Test
    public void canCreateApplication() {
        resource.createApplication();
    }
}