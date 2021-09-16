package academy.pocu.comp2500.assignment1;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;

public class PostComment {
    private String authorId;

    private String body;

    private OffsetDateTime createdDateTime;
    private OffsetDateTime modifiedDateTime;

    private HashSet<String> upvoteUserIds;
    private HashSet<String> downvoteUserIds;

    private LinkedList<PostComment> subcomments;


    public PostComment(String authorId, String body) {
        this.authorId = authorId;

        this.body = body;

        this.createdDateTime = OffsetDateTime.now();
        this.modifiedDateTime = createdDateTime;

        this.upvoteUserIds = new HashSet<String>();
        this.downvoteUserIds = new HashSet<String>();

        this.subcomments = new LinkedList<PostComment>();
    }

    public String getAuthorId() {
        return authorId;
    }

    public boolean isAuthor(String userId) {
        if (this.authorId.equals(userId)) {
            return true;
        } else {
            return false;
        }
    }

    public String getBody() {
        return body;
    }

    public boolean updateBodyCheckIsAuthor(String userId, String body) {
        if (this.isAuthor(userId) == false) {
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
        return subcomments;
    }

    public LinkedList<PostComment> getSortedSubcomments() {
        Collections.sort(subcomments, Comparator.comparing(PostComment::getVoteScore).reversed());
        return subcomments;
    }

    public void addSubcomment(PostComment comment) {
        this.subcomments.add(comment);
    }

    public int getVoteScore() {
        return getUpvoteCount() - getDownvoteCount();
    }

    public HashSet<String> getUpvoteUserIds() {
        return upvoteUserIds;
    }

    public int getUpvoteCount() {
        return upvoteUserIds.size();
    }

    public void upvote(String userId) {
        downvoteUserIds.remove(userId);
        upvoteUserIds.add(userId);
    }

    public HashSet<String> getDownvoteUserIds() {
        return downvoteUserIds;
    }

    public int getDownvoteCount() {
        return downvoteUserIds.size();
    }

    public void downvote(String userId) {
        upvoteUserIds.remove(userId);
        downvoteUserIds.add(userId);
    }

    public String printString() {
        return String.format("name: %s, body: %s, upvote count: %d, downvote count: %d", this.getAuthorId(), this.getBody(), this.getUpvoteCount(), this.getDownvoteCount());
    }

    public void printSubcomments() {
        for (PostComment subcomment : subcomments) {
            System.out.format(" - %s\n", subcomment.printString());
        }
    }

    private void nowSetModifiedDateTime() {
        this.modifiedDateTime = OffsetDateTime.now();
    }
}
