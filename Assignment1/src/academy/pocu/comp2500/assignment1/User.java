package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;

public class User {
    private final String id;

    public User(final String id) {
        assert (id.equals("") != true);
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
