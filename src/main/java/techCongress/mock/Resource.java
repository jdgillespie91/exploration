package techCongress.mock;

public class Resource {
    private final Delegate delegate;

    Resource(Delegate delegate) {
        this.delegate = delegate;
    }

    public void createApplication() {
        delegate.createApplication();
    }
}
