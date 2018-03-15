package techCongress.mock;

public class Resource {
    private final Delegate delegate;

    Resource(Delegate delegate) {
        this.delegate = delegate;
    }

    public void createApplication() {
        delegate.createApplication();
    }

    public void createApplication(String type) {
        delegate.createApplication(type);
    }
}
