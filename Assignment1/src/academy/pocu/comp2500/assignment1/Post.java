package academy.pocu.comp2500.assignment1;

import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Post {
    private int authorId;
    private String authorName;

    private HashSet<String> tags;

    private String title;
    private String body;

    private OffsetDateTime createdDateTime;
    private OffsetDateTime modifiedDateTime;

    private LinkedList<PostComment> comments;

    private HashMap<User, EPostReaction> reactions;
    private int greatReactionCount;
    private int sadReactionCount;
    private int angryReactionCount;
    private int funReactionCount;
    private int loveReactionCount;

    public Post(int authorId, String authorName, HashSet<String> tags, String title, String body) {
        this.authorId = authorId;
        this.authorName = authorName;

        this.tags = tags;
        this.title = title;
        this.body = body;

        this.createdDateTime = OffsetDateTime.now();
        this.modifiedDateTime = createdDateTime;

        comments = new LinkedList<PostComment>();

        reactions = new HashMap<User, EPostReaction>();
    }

    public int getAuthorId() {
        return authorId;
    }

    public boolean isAuthor(int userId) {
        if (this.authorId == userId) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isTagsContain(HashSet<String> tags) {
        for (String tag : tags) {
            if (this.getTags().contains(tag) == false) {
                return false;
            }
        }
        return true;
    }

    public HashSet<String> getTags() {
        return this.tags;
    }

    public void addTag(String tag) {
        this.tags.add(tag);
    }

    public String getTitle() {
        return title;
    }

    public boolean setTitleCheckIsAuthor(int userId, String title) {
        if (isAuthor(userId) == false) {
            return false;
        }

        this.title = title;
        nowSetModifiedDateTime();
        return true;
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

    public LinkedList<PostComment> getComments() {
        sortingComments();
        return comments;
    }

    public void addComment(PostComment comment) {
        this.comments.add(comment);
    }

    public int getReactionCount(EPostReaction reaction) {
        switch (reaction) {
            case GREAT:
                return greatReactionCount;
            case SAD:
                return sadReactionCount;
            case ANGRY:
                return angryReactionCount;
            case FUN:
                return funReactionCount;
            case LOVE:
                return loveReactionCount;
            default:
                assert (false);
                return -1;
        }
    }

    public void addReaction(User user, EPostReaction reaction) {
        removeReaction(user);

        this.reactions.put(user, reaction);

        switch (reaction) {
            case GREAT:
                greatReactionCount++;
                break;
            case SAD:
                sadReactionCount++;
                break;
            case ANGRY:
                angryReactionCount++;
                break;
            case FUN:
                funReactionCount++;
                break;
            case LOVE:
                loveReactionCount++;
                break;
            default:
                assert (false);
        }
    }

    public void removeReaction(User user) {
        if (this.reactions.containsKey(user) == false) {
            return;
        }

        EPostReaction reaction = this.reactions.get(user);

        this.reactions.remove(user);

        switch (reaction) {
            case GREAT:
                greatReactionCount--;
                break;
            case SAD:
                sadReactionCount--;
                break;
            case ANGRY:
                angryReactionCount--;
                break;
            case FUN:
                funReactionCount--;
                break;
            case LOVE:
                loveReactionCount--;
                break;
            default:
                assert (false);
        }
    }

    public void printComments() {
        for (PostComment comment : getComments()) {
            System.out.println(comment.getPrintString());
            comment.printSubcomments();
        }
    }

    public void print() {
        System.out.format("author: %s, created date: %s, modified date: %s, tag: %s, title: %s, body: %s\n",
                this.authorName, this.getCreatedDateTime(), this.getModifiedDateTime(), this.getTags(), this.getTitle(), this.getBody());
    }

    private void nowSetModifiedDateTime() {
        this.modifiedDateTime = OffsetDateTime.now();
    }

    private void sortingComments() {
        Collections.sort(comments, Comparator.comparing(PostComment::getVoteScore).reversed());
    }
}