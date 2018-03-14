package techCongress.stub;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public abstract class EventRepositoryTestBase {
    private AbstractEventRepository eventRepository;

    abstract AbstractEventRepository createEventRepository();

    @Rule
    public Timeout globalTimeout = Timeout.seconds(3);

    @Before
    public void setup() {
        eventRepository = createEventRepository();
    }

    @Test
    public void canSave() {
        eventRepository.save(new Event());
    }
}
