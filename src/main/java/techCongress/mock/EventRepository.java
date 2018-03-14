package techCongress.mock;

import org.mongodb.morphia.Datastore;

class EventRepository {
    private final Datastore datastore;

    EventRepository(Datastore datastore) {
        this.datastore = datastore;
    }

    public void save(Event event) {
        datastore.save(event);
    }
}
