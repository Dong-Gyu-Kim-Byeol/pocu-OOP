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

    private HashSet<Integer> upvotes;
    private HashSet<Integer> downvotes;

    private LinkedList<PostComment> subcomments;


    public PostComment(int authorId, String authorName, String body) {
        this.authorId = authorId;
        this.authorName = authorName;

        this.body = body;

        this.createdDateTime = OffsetDateTime.now();
        this.modifiedDateTime = createdDateTime;

        this.upvotes = new HashSet<>();
        this.downvotes = new HashSet<>();

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

    public String getAuthorName() {
        return authorName;
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

    public void upvote(int userId) {
        if (upvotes.contains(userId) == true) {
            return;
        }

        if (downvotes.contains(userId) == true) {
            downvotes.remove(userId);
        }

        upvotes.add(userId);
    }

    public int getDownvoteCount() {
        return downvotes.size();
    }

    public void downvote(int userId) {
        if (downvotes.contains(userId) == true) {
            return;
        }

        if (upvotes.contains(userId) == true) {
            upvotes.remove(userId);
        }

        downvotes.add(userId);
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
