package techCongress.stub;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class ResourceTest {
    private Resource resource;
    private AbstractApplicationRepository applicationRepository;

    @Before
    public void setup() {
        applicationRepository = new StubApplicationRepository();
        StubEventRepository eventRepository = new StubEventRepository();
        resource = new Resource(applicationRepository, eventRepository);
    }

    @Test
    public void canCreateApplication() {
        resource.createApplication();
    }

    @Test
    public void createApplicationCreatesPGDApplication() {
        resource.createApplication();

        Application application = applicationRepository.get();
        assertThat(application.getType(), equalTo("PGD"));
    }

    @Test
    public void createPGMApplicationCreatesPGMApplication() {
        resource.createApplication("PGM");

        Application application = applicationRepository.get();
        assertThat(application.getType(), equalTo("PGM"));
    }
}