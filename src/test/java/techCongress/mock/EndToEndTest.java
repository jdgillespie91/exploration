package techCongress.mock;

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
    private Resource resource;
    private Datastore datastore;

    @Rule
    public Timeout globalTimeout = Timeout.seconds(3);

    @Before
    public void setup() {
        datastore = getDatastore();
        resource = getResource(datastore);

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

    private static Datastore getDatastore() {
        final Morphia morphia = new Morphia();
        final MongoClient client = new MongoClient("localhost", 27017);
        return morphia.createDatastore(client, "exploration");
    }

    private static Resource getResource(Datastore datastore) {
        ApplicationRepository applicationRepository = new ApplicationRepository(datastore);
        EventRepository eventRepository = new EventRepository(datastore);
        Service service = new Service(applicationRepository, eventRepository);
        Delegate delegate = new Delegate(service);
        return new Resource(delegate);
    }
}
