package techCongress.mock;

class Delegate {
    private final Service service;

    Delegate(Service service) {
        this.service = service;
    }

    public void createApplication() {
        service.createApplication();
    }
}
