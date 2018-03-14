package techCongress.mock;

class Service {
    private final ApplicationRepository applicationRepository;
    private final EventRepository eventRepository;

    Service(ApplicationRepository applicationRepository, EventRepository eventRepository) {
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
