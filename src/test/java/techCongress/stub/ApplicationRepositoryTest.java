package techCongress.stub;

public class ApplicationRepositoryTest extends ApplicationRepositoryTestBase {
    AbstractApplicationRepository createApplicationRepository() {
        return new ApplicationRepository();
    }
}
