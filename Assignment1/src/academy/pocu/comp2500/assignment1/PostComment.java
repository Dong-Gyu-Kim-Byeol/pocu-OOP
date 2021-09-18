package academy.pocu.comp2500.assignment1;

import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;

public class PostComment {
    private final User author;

    private String body;

    private final OffsetDateTime createdDateTime;
    private OffsetDateTime modifiedDateTime;

    private final HashSet<String> upvoteUserIds;
    private final HashSet<String> downvoteUserIds;

    private final LinkedList<PostComment> subcomments;


    public PostComment(final User author, final String body) {
        this.author = author;

        this.body = body;

        this.createdDateTime = OffsetDateTime.now();
        this.modifiedDateTime = createdDateTime;

        this.upvoteUserIds = new HashSet<String>();
        this.downvoteUserIds = new HashSet<String>();

        this.subcomments = new LinkedList<PostComment>();
    }

    public User getAuthor() {
        return author;
    }

    public String getAuthorId() {
        return author.getId();
    }

    public boolean isAuthor(final String userId) {
        if (this.getAuthorId().equals(userId)) {
            return true;
        } else {
            return false;
        }
    }

    public String getBody() {
        return body;
    }

    public boolean updateBodyCheckIsAuthor(final String userId, final String body) {
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

    public LinkedList<PostComment> getSortedSubcomments() {
        Collections.sort(subcomments, Comparator.comparing(PostComment::getVoteScore).reversed());
        return subcomments;
    }

    public void addSubcomment(final PostComment comment) {
        this.subcomments.add(comment);
    }

    public int getVoteScore() {
        return getUpvoteCount() - getDownvoteCount();
    }

    public int getUpvoteCount() {
        return upvoteUserIds.size();
    }

    public void upvote(final String userId) {
        downvoteUserIds.remove(userId);
        upvoteUserIds.add(userId);
    }

    public int getDownvoteCount() {
        return downvoteUserIds.size();
    }

    public void downvote(final String userId) {
        upvoteUserIds.remove(userId);
        downvoteUserIds.add(userId);
    }

    public String printString() {
        return String.format("name: %s, body: %s, upvote count: %d, downvote count: %d", this.getAuthorId(), this.getBody(), this.getUpvoteCount(), this.getDownvoteCount());
    }

    public void printSubcomments() {
        for (final PostComment subcomment : subcomments) {
            System.out.format(" - %s\n", subcomment.printString());
        }
    }

    private void nowSetModifiedDateTime() {
        this.modifiedDateTime = OffsetDateTime.now();
    }
}
