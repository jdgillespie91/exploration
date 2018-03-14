package random;

public class Parent {
    private String firstString;
    private String secondString;

    Parent(String firstString, String secondString) {
        this.firstString = firstString;
        this.secondString = secondString;
    }

    Parent(String firstString) {
        this.firstString = firstString;
        this.secondString = "a-different-string";
    }

    public boolean stringsAreEqual() {
        return firstString.equals(secondString);
    }
}
