package techCongress.stub;

public class Delegate {
    private final Service service;

    Delegate(AbstractApplicationRepository applicationRepository, AbstractEventRepository eventRepository) {
        service = new Service(applicationRepository, eventRepository);
    }

    public void createApplication() {
        service.createApplication();
    }
}
