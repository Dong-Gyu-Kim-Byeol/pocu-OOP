package academy.pocu.comp2500.assignment1.app;

import java.util.LinkedList;

public class Blog {
    private String name;
    private LinkedList<Post> posts;

    public Blog(String name) {
        assert (name.equals("") != true);
        this.name = name;
        this.posts = new LinkedList<Post>();
    }

    public void addPost(User author, String title, String body) {
        Post newPost = new Post(author, title, body);
        this.posts.add(newPost);
    }

    public LinkedList<Post> getPosts() {
        return this.posts;
    }
}
