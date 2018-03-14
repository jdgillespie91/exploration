package techCongress.stub;

class Service {
    private final AbstractApplicationRepository applicationRepository;
    private final AbstractEventRepository eventRepository;

    Service(AbstractApplicationRepository applicationRepository, AbstractEventRepository eventRepository) {
        this.applicationRepository = applicationRepository;
        this.eventRepository = eventRepository;
    }

    public void createApplication() {
        Application application = new Application();
        applicationRepository.save(application);

        Event event = new Event();
        eventRepository.save(event);
    }
}
