package techCongress.stub;


import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

public class EventRepository implements AbstractEventRepository {
    private final Datastore datastore;

    EventRepository() {
        datastore = getDatastore();
    }

    public void save(Event event) {
        datastore.save(event);
    }

    private static Datastore getDatastore() {
        final Morphia morphia = new Morphia();
        final MongoClient client = new MongoClient("localhost", 27017);
        return morphia.createDatastore(client, "exploration");
    }
}
