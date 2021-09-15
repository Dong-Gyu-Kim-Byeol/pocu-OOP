package academy.pocu.comp2500.assignment1;

import java.time.OffsetDateTime;
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

    private HashMap<EPostReaction, HashSet<User>> reactions;

    public Post(User author, HashSet<String> tags, String title, String body) {
        this.author = author;

        this.tags = tags;

        assert (title.equals("") != true);
        this.title = title;

        assert (body.equals("") != true);
        this.body = body;

        this.createdDateTime = OffsetDateTime.now();
        this.modifiedDateTime = createdDateTime;

        comments = new LinkedList<PostComment>();

        reactions = new HashMap<EPostReaction, HashSet<User>>();
        reactions.put(EPostReaction.GREAT, new HashSet<User>());
        reactions.put(EPostReaction.FUN, new HashSet<User>());
        reactions.put(EPostReaction.ANGRY, new HashSet<User>());
        reactions.put(EPostReaction.SAD, new HashSet<User>());
        reactions.put(EPostReaction.LOVE, new HashSet<User>());
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

    public void addTag(User author, String tag) {
        if (isAuthor(author) == false) {
            return;
        }

        if (tag.equals("")) {
            return;
        }

        this.tags.add(tag);
    }

    public String getTitle() {
        return title;
    }

    public boolean setTitle(User author, String title) {
        if (isAuthor(author) == false) {
            return false;
        }

        if (title.equals("")) {
            return false;
        }

        this.title = title;
        nowSetModifiedDateTime();
        return true;
    }

    public String getBody() {
        return body;
    }

    public boolean setBody(User author, String body) {
        if (isAuthor(author) == false) {
            return false;
        }

        if (title.equals("")) {
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

    public HashSet<User> getReactions(EPostReaction reaction) {
        return this.reactions.get(reaction);
    }

    public void addReaction(User user, EPostReaction reaction) {
        this.reactions.get(reaction).add(user);
    }

    public void deleteReaction(User user) {
        for (HashSet<User> reactions : this.reactions.values()) {
            reactions.remove(user);
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
                this.getAuthor().getName(), this.getCreatedDateTime(), this.getModifiedDateTime(), this.getTags(), this.getTitle(), this.getBody());
    }

    private void nowSetModifiedDateTime() {
        this.modifiedDateTime = OffsetDateTime.now();
    }

    private void sortingComments() {
        Collections.sort(comments, Comparator.comparing(PostComment::getVoteScore).reversed());
    }
}