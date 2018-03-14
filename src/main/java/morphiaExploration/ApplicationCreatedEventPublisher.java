package morphiaExploration;

class ApplicationCreatedEventPublisher {
    private static MongoAdapter mongoAdapter = new MongoAdapter();

    public static void publish(Application application) {
        mongoAdapter.saveApplicationCreatedEvent(application);
    }
}
