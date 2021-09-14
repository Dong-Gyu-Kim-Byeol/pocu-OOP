package academy.pocu.comp2500.assignment1;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class PostComment {
    private User author;
    private String body;
    private LinkedList<User> upvotes;
    private LinkedList<User> downvotes;
    private LinkedList<PostComment> subcomments;


    public PostComment(User author, String body) {
        this.author = author;

        assert (body.equals("") != true);
        this.body = body;

        this.upvotes = new LinkedList<User>();
        this.downvotes = new LinkedList<User>();

        this.subcomments = new LinkedList<PostComment>();
    }

    public User getAuthor() {
        return author;
    }

    public boolean isAuthor(User user) {
        if (this.author == user) {
            return true;
        } else {
            return false;
        }
    }

    public String getBody() {
        return body;
    }

    public void setBody(User author, String body) {
        if (isAuthor(author) == false) {
            return;
        }

        if (body.equals("") == true) {
            return;
        }

        this.body = body;
    }

    public LinkedList<PostComment> getSubcomments() {
        sortSubcomments();
        return subcomments;
    }

    public void sortSubcomments() {
        Collections.sort(subcomments, Comparator.comparing(PostComment::getVoteScore).reversed());
    }

    public void addSubcomment(PostComment comment) {
        this.subcomments.add(comment);
    }

    public int getVoteScore() {
        return getUpvoteCount() - getDownvoteCount();
    }

    public int getUpvoteCount() {
        return upvotes.size();
    }

    public void upvote(User user) {
        if (upvotes.contains(user) == true) {
            return;
        }

        if (downvotes.contains(user) == true) {
            downvotes.remove(user);
        }

        upvotes.add(user);
    }

    public int getDownvoteCount() {
        return downvotes.size();
    }

    public void downvote(User user) {
        if (downvotes.contains(user) == true) {
            return;
        }

        if (upvotes.contains(user) == true) {
            upvotes.remove(user);
        }

        downvotes.add(user);
    }

    public String getPrintString() {
        return String.format("name: %s, body: %s, upvote count: %d, downvote count: %d", this.getAuthor().getName(), this.getBody(), this.getUpvoteCount(), this.getDownvoteCount());
    }

    public void printSubcomments() {
        for (PostComment subcomment : subcomments) {
            System.out.format(" - %s\n", subcomment.getPrintString());
        }
    }
}
