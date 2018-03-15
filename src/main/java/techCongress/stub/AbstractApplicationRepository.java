package techCongress.stub;

public interface AbstractApplicationRepository {
    void save(Application application);

    Application get();

    void empty();
}
