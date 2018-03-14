package techCongress.stub;

public class StubEventRepositoryTest extends EventRepositoryTestBase {
    AbstractEventRepository createEventRepository() {
        return new StubEventRepository();
    }
}
