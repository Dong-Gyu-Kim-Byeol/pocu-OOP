package academy.pocu.comp2500.assignment1.app;

import java.util.ArrayList;
import java.util.LinkedList;

public class PostComment {
    private User author;
    private String body;
    private LinkedList<User> upvotes;
    private LinkedList<User> downvotes;
    private ArrayList<PostComment> subcomments;

    public PostComment(User author, String body) {
        this.author = author;

        assert (body.equals("") != true);
        this.body = body;

        this.subcomments = new ArrayList<PostComment>();
    }

    public String getAuthorName() {
        return author.getName();
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        assert (body.equals(""));
        this.body = body;
    }

    public ArrayList<PostComment> getSubcomments() {
        return subcomments;
    }

    public void addSubcomment(PostComment subcomment) {
        this.subcomments.add(subcomment);
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

    public void downvote(User user) {
        if (downvotes.contains(user) == true) {
            return;
        }

        if (upvotes.contains(user) == true) {
            upvotes.remove(user);
        }

        downvotes.add(user);
    }

    public int getDownvoteCount() {
        return downvotes.size();
    }

    public static void printSubcommentRecursive(ArrayList<PostComment> subcomments){
        for(PostComment subcomment : subcomments){
            System.out.format("name: %s, body: %s\n", subcomment.getAuthorName(), subcomment.getBody());
            PostComment.printSubcommentRecursive(subcomment.getSubcomments());
        }
    }
}
