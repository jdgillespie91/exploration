package morphiaExploration;

import com.mongodb.MongoClient;
import org.junit.Before;
import org.junit.Test;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import static org.junit.Assert.assertEquals;

public class ControllerTest {
    private Datastore ds = getDatastore();

    @Before
    public void setup() {
        ds.delete(ds.createQuery(Application.class));
        ds.delete(ds.createQuery(ApplicationCreatedEvent.class));
    }

    @Test
    public void testMainCreatesPGDApplication() {
        Controller.main();

        long actualApplicationCount = ds.createQuery(Application.class)
                .field("applicationType").equal("PGD")
                .count();
        assertEquals(1, actualApplicationCount);
    }

    @Test
    public void testMainCreatesPGMApplication() {
        Controller.main();

        long actualApplicationCount = ds.createQuery(Application.class)
                .field("applicationType").equal("PGM")
                .count();
        assertEquals(1, actualApplicationCount);
    }

    @Test
    public void testMainCreatesApplicationCreatedEventForPGD() {
        Controller.main();

        long actualEventCount = ds.createQuery(ApplicationCreatedEvent.class)
                .field("type").equal("applicationCreated")
                .field("applicationType").equal("PGD")
                .count();
        assertEquals(1, actualEventCount);
    }

    @Test
    public void testMainDoesNotCreateApplicationCreatedEventForPGM() {
        Controller.main();

        long actualEventCount = ds.createQuery(ApplicationCreatedEvent.class)
                .field("type").equal("applicationCreated")
                .field("applicationType").equal("PGM")
                .count();
        assertEquals(0, actualEventCount);
    }

    private Datastore getDatastore() {
        final Morphia morphia = new Morphia();
        final MongoClient client = new MongoClient("localhost", 27017);
        return morphia.createDatastore(client, "exploration");
    }
}