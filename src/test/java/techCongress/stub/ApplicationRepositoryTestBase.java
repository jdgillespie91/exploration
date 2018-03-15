package techCongress.stub;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public abstract class ApplicationRepositoryTestBase {
    private AbstractApplicationRepository applicationRepository;

    abstract AbstractApplicationRepository createApplicationRepository();

    @Rule
    public Timeout globalTimeout = Timeout.seconds(3);

    @Before
    public void setup() {
        applicationRepository = createApplicationRepository();
        applicationRepository.empty();
    }

    @Test
    public void canSave() {
        applicationRepository.save(new Application());
    }

    @Test
    public void getReturnsSavedApplication() {
        Application expectedApplication = new Application();

        applicationRepository.save(expectedApplication);
        Application actualApplication = applicationRepository.get();

        assertThat(expectedApplication.getType(), equalTo(actualApplication.getType()));
    }
}
