package techCongress.mock;

import org.junit.Before;
import org.junit.Test;
import org.mongodb.morphia.Datastore;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class EventRepositoryTest {
    private EventRepository eventRepository;
    private Datastore datastore;

    @Before
    public void setup() {
        datastore = mock(Datastore.class);
        eventRepository = new EventRepository(datastore);
    }

    @Test
    public void canSave() {
        eventRepository.save(new Event());
    }

    @Test
    public void saveCallsDatastoreSave() {
        Event event = new Event();
        eventRepository.save(event);
        verify(datastore).save(event);
    }
}