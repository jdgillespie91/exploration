package techCongress.stub;


import java.util.ArrayList;
import java.util.List;

public class StubApplicationRepository implements AbstractApplicationRepository {
    private List<Application> applications = new ArrayList<>();

    public void save(Application application) {
        applications.add(application);
    }

    public Application get() {
        return applications.get(0);
    }

    public void empty() {
        applications.clear();
    }
}
