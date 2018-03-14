package morphiaExploration;

import java.util.ArrayList;
import java.util.List;

class ApplicationCreator {
    private static MongoAdapter mongoAdapter = new MongoAdapter();

    static List<Application> createApplications() {
        List<Application> applications = new ArrayList<>();

        applications.add(createApplication(new Application("PGD")));
        applications.add(createApplication(new Application("PGM")));

        return applications;
    }

    private static Application createApplication(Application application) {
        return mongoAdapter.saveApplication(application);
    }
}
