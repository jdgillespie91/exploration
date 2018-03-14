package morphiaExploration;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.Morphia;

public class MongoAdapter {
    private static Datastore ds;

    MongoAdapter() {
        final Morphia morphia = new Morphia();
        final MongoClient client = new MongoClient("localhost", 27017);
        ds = morphia.createDatastore(client, "exploration");
    }

    public Application saveApplication(Application application) {
        Key<Application> mongoApplication = ds.save(application);
        return ds.get(Application.class, mongoApplication.getId());
    }

    public void saveApplicationCreatedEvent(Application application) {
        ds.save(new ApplicationCreatedEvent(application));
    }
}
