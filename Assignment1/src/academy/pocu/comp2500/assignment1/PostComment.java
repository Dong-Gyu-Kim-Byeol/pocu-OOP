package academy.pocu.comp2500.assignment1;

import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;

public class PostComment {
    private int authorId;
    private String authorName;

    private String body;

    private OffsetDateTime createdDateTime;
    private OffsetDateTime modifiedDateTime;

    private HashSet<User> upvotes;
    private HashSet<User> downvotes;

    private LinkedList<PostComment> subcomments;


    public PostComment(int authorId, String authorName, String body) {
        this.authorId = authorId;
        this.authorName = authorName;

        this.body = body;

        this.createdDateTime = OffsetDateTime.now();
        this.modifiedDateTime = createdDateTime;

        this.upvotes = new HashSet<User>();
        this.downvotes = new HashSet<User>();

        this.subcomments = new LinkedList<PostComment>();
    }

    public int getAuthor() {
        return authorId;
    }

    public boolean isAuthor(int userId) {
        if (this.authorId == userId) {
            return true;
        } else {
            return false;
        }
    }

    public String getBody() {
        return body;
    }

    public boolean setBodyCheckIsAuthor(int userId, String body) {
        if (isAuthor(userId) == false) {
            return false;
        }

        this.body = body;
        nowSetModifiedDateTime();
        return true;
    }

    public OffsetDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public OffsetDateTime getModifiedDateTime() {
        return modifiedDateTime;
    }

    public LinkedList<PostComment> getSubcomments() {
        sortingSubcomments();
        return subcomments;
    }

    public void sortingSubcomments() {
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
        return String.format("name: %s, body: %s, upvote count: %d, downvote count: %d", this.authorName, this.getBody(), this.getUpvoteCount(), this.getDownvoteCount());
    }

    public void printSubcomments() {
        for (PostComment subcomment : subcomments) {
            System.out.format(" - %s\n", subcomment.getPrintString());
        }
    }

    private void nowSetModifiedDateTime() {
        this.modifiedDateTime = OffsetDateTime.now();
    }
}
