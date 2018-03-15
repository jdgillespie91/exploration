package techCongress.stub;

import com.mongodb.MongoClient;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class EndToEndTest {
    private Datastore datastore;
    private Resource resource;

    @Rule
    public Timeout globalTimeout = Timeout.seconds(3);

    @Before
    public void setup() {
        datastore = getDatastore();
        resource = getResource();

        datastore.delete(datastore.createQuery(Application.class));
        datastore.delete(datastore.createQuery(Event.class));
    }

    @Test
    public void createApplicationCreatesPGDApplicationDocument() {
        resource.createApplication();

        List<Application> applications = datastore.find(Application.class).asList();
        assertThat(applications.size(), equalTo(1));
        assertThat(applications.get(0).getType(), equalTo("PGD"));
    }

    @Test
    public void createPGMApplicationCreatesPGMApplicationDocument() {
        resource.createApplication("PGM");

        List<Application> applications = datastore.find(Application.class).asList();
        assertThat(applications.size(), equalTo(1));
        assertThat(applications.get(0).getType(), equalTo("PGM"));
    }

    @Test
    public void createApplicationCreatesEventDocument() {
        resource.createApplication();

        assertThat(datastore.find(Event.class).asList().size(), equalTo(1));
    }

    private static Datastore getDatastore() {
        final Morphia morphia = new Morphia();
        final MongoClient client = new MongoClient("localhost", 27017);
        return morphia.createDatastore(client, "exploration");
    }

    private static Resource getResource() {
        ApplicationRepository applicationRepository = new ApplicationRepository();
        EventRepository eventRepository = new EventRepository();
        return new Resource(applicationRepository, eventRepository);
    }
}
