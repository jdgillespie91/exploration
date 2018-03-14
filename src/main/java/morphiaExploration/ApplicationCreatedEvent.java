package morphiaExploration;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import java.util.UUID;

@Entity("events")
class ApplicationCreatedEvent {
    @Id
    private ObjectId id;
    private String type;
    private UUID applicationId;
    private String applicationType;

    ApplicationCreatedEvent() {
    }

    ApplicationCreatedEvent(Application application) {
        this.type = "applicationCreated";
        this.applicationId = application.getApplicationId();
        this.applicationType = application.getApplicationType();
    }
}
