package academy.pocu.comp2500.assignment1;

import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;

public class Post {
    private User author;

    private HashSet<String> tags;

    private String title;
    private String body;

    private OffsetDateTime createdDateTime;
    private OffsetDateTime modifiedDateTime;

    private LinkedList<PostComment> comments;

    private HashSet<String> greatUserIdReactions;
    private HashSet<String> sadUserIdReactions;
    private HashSet<String> angryUserIdReactions;
    private HashSet<String> funUserIdReactions;
    private HashSet<String> loveUserIdReactions;

    public Post(User author, HashSet<String> tags, String title, String body) {
        this.author = author;

        this.tags = tags;
        this.title = title;
        this.body = body;

        this.createdDateTime = OffsetDateTime.now();
        this.modifiedDateTime = createdDateTime;

        comments = new LinkedList<PostComment>();

        greatUserIdReactions = new HashSet<String>();
        sadUserIdReactions = new HashSet<String>();
        angryUserIdReactions = new HashSet<String>();
        funUserIdReactions = new HashSet<String>();
        loveUserIdReactions = new HashSet<String>();
    }

    public User getAuthor() {
        return author;
    }

    public String getAuthorId() {
        return author.getId();
    }

    public boolean isAuthor(String userId) {
        if (this.getAuthorId().equals(userId) == true) {
            return true;
        } else {
            return false;
        }
    }

    public HashSet<String> getTags() {
        return this.tags;
    }

    public boolean isTagsContainEvenOne(HashSet<String> tags) {
        for (String tag : tags) {
            if (this.getTags().contains(tag) == true) {
                return true;
            }
        }
        return false;
    }

    public void addTag(String tag) {
        this.tags.add(tag);
    }

    public void removeTag(String tag) {
        this.tags.remove(tag);
    }

    public String getTitle() {
        return title;
    }

    public boolean updateTitleCheckIsAuthor(String userId, String title) {
        if (this.isAuthor(userId) == false) {
            return false;
        }

        this.title = title;
        nowSetModifiedDateTime();
        return true;
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

    public LinkedList<PostComment> getSortedComments() {
        Collections.sort(comments, Comparator.comparing(PostComment::getVoteScore).reversed());
        return comments;
    }

    public void addComment(PostComment comment) {
        this.comments.add(comment);
    }

    public int getReactionCount(EPostReaction reaction) {
        switch (reaction) {
            case GREAT:
                return greatUserIdReactions.size();
            case SAD:
                return sadUserIdReactions.size();
            case ANGRY:
                return angryUserIdReactions.size();
            case FUN:
                return funUserIdReactions.size();
            case LOVE:
                return loveUserIdReactions.size();
            default:
                assert (false);
                return -1;
        }
    }

    public void addReaction(String userId, EPostReaction reaction) {
        removeAllReaction(userId);

        switch (reaction) {
            case GREAT:
                greatUserIdReactions.add(userId);
                break;
            case SAD:
                sadUserIdReactions.add(userId);
                break;
            case ANGRY:
                angryUserIdReactions.add(userId);
                break;
            case FUN:
                funUserIdReactions.add(userId);
                break;
            case LOVE:
                loveUserIdReactions.add(userId);
                break;
            default:
                assert (false);
        }
    }

    public void removeReaction(String userId, EPostReaction reaction) {
        switch (reaction) {
            case GREAT:
                greatUserIdReactions.remove(userId);
                break;
            case SAD:
                sadUserIdReactions.remove(userId);
                break;
            case ANGRY:
                angryUserIdReactions.remove(userId);
                break;
            case FUN:
                funUserIdReactions.remove(userId);
                break;
            case LOVE:
                loveUserIdReactions.remove(userId);
                break;
            default:
                assert (false);
        }
    }

    public void printComments() {
        for (PostComment comment : getSortedComments()) {
            System.out.println(comment.printString());
            comment.printSubcomments();
        }
    }

    public void print() {
        System.out.format("author: %s, created date: %s, modified date: %s, tag: %s, title: %s, body: %s\n",
                this.getAuthorId(), this.getCreatedDateTime(), this.getModifiedDateTime(), this.getTags(), this.getTitle(), this.getBody());
    }

    private void nowSetModifiedDateTime() {
        this.modifiedDateTime = OffsetDateTime.now();
    }

    private void removeAllReaction(String userId) {
        greatUserIdReactions.remove(userId);
        sadUserIdReactions.remove(userId);
        angryUserIdReactions.remove(userId);
        funUserIdReactions.remove(userId);
        loveUserIdReactions.remove(userId);
    }
}