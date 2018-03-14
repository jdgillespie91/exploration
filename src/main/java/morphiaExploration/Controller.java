package morphiaExploration;

import java.util.List;

import static morphiaExploration.ApplicationCreator.createApplications;

public class Controller {
    public static void main() {
        List<Application> applications = createApplications();
        applications
                .stream()
                .filter(Application::isDoctoralApplication)
                .forEach(ApplicationCreatedEventPublisher::publish);
    }
}
