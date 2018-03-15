package techCongress.stub;


import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

public class ApplicationRepository implements AbstractApplicationRepository {
    private final Datastore datastore;

    ApplicationRepository() {
        datastore = getDatastore();
    }

    public void save(Application application) {
        datastore.save(application);
    }

    public Application get() {
        return datastore.find(Application.class).asList().get(0);
    }

    public void empty() {
        datastore.delete(datastore.createQuery(Application.class));
    }

    private static Datastore getDatastore() {
        final Morphia morphia = new Morphia();
        final MongoClient client = new MongoClient("localhost", 27017);
        return morphia.createDatastore(client, "exploration");
    }
}
