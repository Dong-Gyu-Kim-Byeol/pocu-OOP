package academy.pocu.comp2500.assignment1.app;

import java.util.LinkedList;

public class Post {
    private User author;
    private String title;
    private String body;
    private LinkedList<PostComment> comments;

    public Post(User author, String title, String body) {
        this.author = author;

        assert(title.equals("") != true);
        this.title = title;

        assert(body.equals("") != true);
        this.body = body;

        comments = new LinkedList<PostComment>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        assert(title.equals("") != true);
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        assert(body.equals("") != true);
        this.body = body;
    }

    public LinkedList<PostComment> getComments() {
        return comments;
    }

    public void addComment(PostComment comment) {
        this.comments.add(comment);
    }
}
