package techCongress.stub;

public class Resource {
    private final Delegate delegate;

    Resource(AbstractApplicationRepository applicationRepository, AbstractEventRepository eventRepository) {
        delegate = new Delegate(applicationRepository, eventRepository);
    }

    public void createApplication() {
        delegate.createApplication();
    }
}
