package techCongress.mock;

import org.mongodb.morphia.Datastore;

class ApplicationRepository {
    private final Datastore datastore;

    ApplicationRepository(Datastore datastore) {
        this.datastore = datastore;
    }

    public void save(Application application) {
        datastore.save(application);
    }
}
