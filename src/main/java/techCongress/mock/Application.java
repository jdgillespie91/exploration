package techCongress.mock;

class Application {
    private String type;

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
