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

    public static void sort(LinkedList<PostComment> comments) {
        Collections.sort(comments, Comparator.comparing(PostComment::getVoteScore));
    }

    public static void printComments(LinkedList<PostComment> comments) {
        for (PostComment comment : comments) {
            System.out.println(comment.getPrintString());
            PostComment.printSubcomments(comment.getSubcomments());
        }
    }

    public PostComment(User author, String body) {
        this.author = author;

        assert (body.equals("") != true);
        this.body = body;

        this.upvotes = new LinkedList<User>();
        this.downvotes = new LinkedList<User>();

        this.subcomments = new LinkedList<PostComment>();
    }

    public String getAuthorName() {
        return author.getName();
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        assert (body.equals(""));
        if (body.equals("") == true) {
            return;
        }

        this.body = body;
    }

    public LinkedList<PostComment> getSubcomments() {
        PostComment.sort(subcomments);
        return subcomments;
    }

    public PostComment addSubcomment(User author, String body) {
        PostComment newSubcomment = new PostComment(author, body);
        this.subcomments.add(newSubcomment);

        return newSubcomment;
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
        return String.format("name: %s, body: %s, upvote count: %d, downvote count: %d", this.getAuthorName(), this.getBody(), this.getUpvoteCount(), this.getDownvoteCount());
    }

    private static void printSubcomments(LinkedList<PostComment> subcomments) {
        for (PostComment subcomment : subcomments) {
            System.out.format(" - %s\n", subcomment.getPrintString());
        }
    }


}
