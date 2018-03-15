package techCongress.mock;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ServiceTest {
    private ApplicationRepository applicationRepository;
    private EventRepository eventRepository;
    private Service service;

    @Before
    public void setup() {
        applicationRepository = mock(ApplicationRepository.class);
        eventRepository = mock(EventRepository.class);
        service = new Service(applicationRepository, eventRepository);
    }

    @Test
    public void canCreateApplication() {
        service.createApplication();
    }

    @Test
    public void createApplicationCallsApplicationRepositorySave() {
        ArgumentCaptor<Application> argumentCaptor = ArgumentCaptor.forClass(Application.class);

        service.createApplication();

        verify(applicationRepository).save(argumentCaptor.capture());
        assertThat(argumentCaptor.getValue(), instanceOf(Application.class));
    }

    @Test
    public void createApplicationWithTypeCallsApplicationRepositorySaveWithTypedApplication() {
        ArgumentCaptor<Application> argumentCaptor = ArgumentCaptor.forClass(Application.class);

        service.createApplication("PGD");

        verify(applicationRepository).save(argumentCaptor.capture());
        assertThat(argumentCaptor.getValue(), instanceOf(Application.class));
        assertThat(argumentCaptor.getValue().getType(), equalTo("PGD"));
    }

    @Test
    public void createApplicationCallsEventRepositorySave() {
        ArgumentCaptor<Event> argumentCaptor = ArgumentCaptor.forClass(Event.class);

        service.createApplication();

        verify(eventRepository).save(argumentCaptor.capture());
        assertThat(argumentCaptor.getValue(), instanceOf(Event.class));
    }
}
