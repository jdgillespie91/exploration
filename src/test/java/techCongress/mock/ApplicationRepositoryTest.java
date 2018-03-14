package techCongress.mock;

import org.junit.Before;
import org.junit.Test;
import org.mongodb.morphia.Datastore;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ApplicationRepositoryTest {
    private ApplicationRepository applicationRepository;
    private Datastore datastore;

    @Before
    public void setup() {
        datastore = mock(Datastore.class);
        applicationRepository = new ApplicationRepository(datastore);
    }

    @Test
    public void canSave() {
        applicationRepository.save(new Application());
    }

    @Test
    public void saveCallsDatastoreSave() {
        Application application = new Application();
        applicationRepository.save(application);
        verify(datastore).save(application);
    }
}