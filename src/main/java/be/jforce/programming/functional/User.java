package be.jforce.programming.functional;

public class User {
    private final String handle;
    private String name;

    public User(String handle, String name) {
        this.handle = handle;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getHandle() {
        return handle;
    }
}
