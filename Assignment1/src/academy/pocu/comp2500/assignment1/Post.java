package academy.pocu.comp2500.assignment1;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
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

    private HashSet<User> greatReactions;
    private HashSet<User> sadReactions;
    private HashSet<User> angryReactions;
    private HashSet<User> funReactions;
    private HashSet<User> loveReactions;

    public Post(User author, HashSet<String> tags, String title, String body) {
        this.author = author;

        this.tags = tags;
        this.title = title;
        this.body = body;

        this.createdDateTime = OffsetDateTime.now();
        this.modifiedDateTime = createdDateTime;

        comments = new LinkedList<PostComment>();

        greatReactions = new HashSet<User>();
        sadReactions = new HashSet<User>();
        angryReactions = new HashSet<User>();
        funReactions = new HashSet<User>();
        loveReactions = new HashSet<User>();
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

    public void setTitle(String title) {
        this.title = title;
        nowSetModifiedDateTime();
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
        nowSetModifiedDateTime();
    }

    public OffsetDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public OffsetDateTime getModifiedDateTime() {
        return modifiedDateTime;
    }

    public LinkedList<PostComment> getComments() {
        return comments;
    }

    public LinkedList<PostComment> getSortedComments() {
        Collections.sort(comments, Comparator.comparing(PostComment::getVoteScore).reversed());
        return comments;
    }

    public void addComment(PostComment comment) {
        this.comments.add(comment);
    }

    public HashSet<User> getReactions(EPostReaction reaction) {
        switch (reaction) {
            case GREAT:
                return greatReactions;
            case SAD:
                return sadReactions;
            case ANGRY:
                return angryReactions;
            case FUN:
                return funReactions;
            case LOVE:
                return loveReactions;
            default:
                assert (false);
                throw new IllegalArgumentException("unknown EPostReaction type");
        }
    }

    public EPostReaction getUserReactionOrNull(User user) {
        if (greatReactions.contains(user)) {
            return EPostReaction.GREAT;
        }

        if (sadReactions.contains(user)) {
            return EPostReaction.SAD;
        }

        if (angryReactions.contains(user)) {
            return EPostReaction.ANGRY;
        }

        if (funReactions.contains(user)) {
            return EPostReaction.FUN;
        }

        if (loveReactions.contains(user)) {
            return EPostReaction.LOVE;
        }

        return null;
    }

    public int getReactionCount(EPostReaction reaction) {
        switch (reaction) {
            case GREAT:
                return greatReactions.size();
            case SAD:
                return sadReactions.size();
            case ANGRY:
                return angryReactions.size();
            case FUN:
                return funReactions.size();
            case LOVE:
                return loveReactions.size();
            default:
                assert (false);
                throw new IllegalArgumentException("unknown EPostReaction type");
        }
    }

    public void addReaction(User user, EPostReaction reaction) {
        removeReaction(user);

        switch (reaction) {
            case GREAT:
                greatReactions.add(user);
                break;
            case SAD:
                sadReactions.add(user);
                break;
            case ANGRY:
                angryReactions.add(user);
                break;
            case FUN:
                funReactions.add(user);
                break;
            case LOVE:
                loveReactions.add(user);
                break;
            default:
                assert (false);
        }
    }

    public void removeReaction(User user) {
        greatReactions.remove(user);
        sadReactions.remove(user);
        angryReactions.remove(user);
        funReactions.remove(user);
        loveReactions.remove(user);
    }

    public void printComments() {
        for (PostComment comment : getSortedComments()) {
            System.out.println(comment.printString());
            comment.printSubcomments();
        }
    }

    public void print() {
        System.out.format("author: %s, created date: %s, modified date: %s, tag: %s, title: %s, body: %s\n",
                this.getAuthor().getName(), this.getCreatedDateTime(), this.getModifiedDateTime(), this.getTags(), this.getTitle(), this.getBody());
    }

    private void nowSetModifiedDateTime() {
        this.modifiedDateTime = OffsetDateTime.now();
    }
}