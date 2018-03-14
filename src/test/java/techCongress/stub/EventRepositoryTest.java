package techCongress.stub;

public class EventRepositoryTest extends EventRepositoryTestBase {
    AbstractEventRepository createEventRepository() {
        return new EventRepository();
    }
}
