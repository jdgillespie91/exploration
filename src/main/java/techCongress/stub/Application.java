package techCongress.stub;

class Application {
    private final String type;

    Application() {
        this("PGD");
    }

    public Application(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
