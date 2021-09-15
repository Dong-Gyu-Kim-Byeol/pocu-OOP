package academy.pocu.comp2500.assignment1;

import java.util.HashSet;

public class AuthorFilter {
    private HashSet<User> authorsFilter;

    public AuthorFilter() {
        this.authorsFilter = new HashSet<User>();
    }

    public HashSet<User> getAuthorsFilter() {
        return authorsFilter;
    }

    public void setAuthorsFilter(HashSet<User> authors) {
        this.authorsFilter = authorsFilter;
    }
}
