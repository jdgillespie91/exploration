package techCongress.stub;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public abstract class ApplicationRepositoryTestBase {
    private AbstractApplicationRepository applicationRepository;

    abstract AbstractApplicationRepository createApplicationRepository();

    @Rule
    public Timeout globalTimeout = Timeout.seconds(3);

    @Before
    public void setup() {
        applicationRepository = createApplicationRepository();
    }

    @Test
    public void canSave() {
        applicationRepository.save(new Application());
    }
}
