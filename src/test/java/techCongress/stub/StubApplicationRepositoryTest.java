package techCongress.stub;

public class StubApplicationRepositoryTest extends ApplicationRepositoryTestBase {
    AbstractApplicationRepository createApplicationRepository() {
        return new StubApplicationRepository();
    }
}
