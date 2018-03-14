package morphiaExploration;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import java.util.UUID;

@Entity("applications")
class Application {
    @Id
    private ObjectId id;
    private UUID applicationId;
    private String applicationType;

    Application() {
        this("PGD");
    }

    Application(String applicationType) {
        this.applicationId = UUID.randomUUID();
        this.applicationType = applicationType;
    }

    public UUID getApplicationId() {
        return applicationId;
    }

    public String getApplicationType() {
        return applicationType;
    }

    public boolean isDoctoralApplication() {
        return applicationType.equals("PGD");
    }
}
