package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Blog {
    private String name;
    private LinkedList<Post> posts;

    public Blog(String name) {
        assert (name.equals("") != true);
        this.name = name;

        this.posts = new LinkedList<Post>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LinkedList<Post> getPosts() {
        return posts;
    }

    public void addPost(Post post) {
        this.posts.add(post);
    }

    public boolean isContainPost(Post post) {
        return posts.contains(post);
    }
}
