package be.jforce.programming.functional;

import java.util.Arrays;
import java.util.List;

public class UserRepository {
    private final List<User> users;

    public UserRepository(User... users) {
        this.users = Arrays.asList(users);
    }

    public User byHandle(String handle) {
        try {
            Thread.sleep(250);
        } catch (InterruptedException e) {
        }
        return users.stream().filter(u -> handle.equalsIgnoreCase(u.getHandle())).findFirst().orElse(null);
    }
}
