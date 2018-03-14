package techCongress.mock;

import com.mongodb.MongoClient;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

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
    public void createApplicationCreatesApplicationDocument() {
        resource.createApplication();

        assertThat(datastore.find(Application.class).asList().size(), equalTo(1));
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

    private static Resource getResource(Datastore datastore) {
        ApplicationRepository applicationRepository = new ApplicationRepository(datastore);
        EventRepository eventRepository = new EventRepository(datastore);
        Service service = new Service(applicationRepository, eventRepository);
        Delegate delegate = new Delegate(service);
        return new Resource(delegate);
    }
}
