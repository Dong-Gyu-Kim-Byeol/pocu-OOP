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

    public static final int GREAT_REACTION_INDEX = 0;
    public static final int SAD_REACTION_INDEX = 1;
    public static final int ANGRY_REACTION_INDEX = 2;
    public static final int FUN_REACTION_INDEX = 3;
    public static final int LOVE_REACTION_INDEX = 4;
    public static final int REACTION_COUNT = 5;

    private ArrayList<HashSet<User>> reactions;

//    private ArrayList<HashSet<User>> greatReactions;
//    private HashSet<User> sadReactions;
//    private HashSet<User> angryReactions;
//    private HashSet<User> funReactions;
//    private HashSet<User> loveReactions;

    public Post(User author, HashSet<String> tags, String title, String body) {
        this.author = author;

        this.tags = tags;
        this.title = title;
        this.body = body;

        this.createdDateTime = OffsetDateTime.now();
        this.modifiedDateTime = createdDateTime;

        comments = new LinkedList<PostComment>();

        reactions = new ArrayList<HashSet<User>>(REACTION_COUNT);
        for (int i = 0; i < REACTION_COUNT; i++) {
            reactions.add(new HashSet<User>());
        }

//        greatReactions = new HashSet<User>();
//        sadReactions = new HashSet<User>();
//        angryReactions = new HashSet<User>();
//        funReactions = new HashSet<User>();
//        loveReactions = new HashSet<User>();
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

    public ArrayList<HashSet<User>> getReactions() {
        return reactions;
    }

    public EPostReaction reactionIndexToEnum(int reaction) {
        switch (reaction) {
            case GREAT_REACTION_INDEX:
                return EPostReaction.GREAT;
            case SAD_REACTION_INDEX:
                return EPostReaction.SAD;
            case ANGRY_REACTION_INDEX:
                return EPostReaction.ANGRY;
            case FUN_REACTION_INDEX:
                return EPostReaction.FUN;
            case LOVE_REACTION_INDEX:
                return EPostReaction.LOVE;
            default:
                assert (false);
                throw new IllegalArgumentException("unknown EPostReaction type");
        }
    }

    public int reactionEnumToIndex(EPostReaction reaction) {
        switch (reaction) {
            case GREAT:
                return GREAT_REACTION_INDEX;
            case SAD:
                return SAD_REACTION_INDEX;
            case ANGRY:
                return ANGRY_REACTION_INDEX;
            case FUN:
                return FUN_REACTION_INDEX;
            case LOVE:
                return LOVE_REACTION_INDEX;
            default:
                assert (false);
                throw new IllegalArgumentException("unknown EPostReaction type");
        }
    }

    public EPostReaction getUserReactionOrNull(User user) {
        for (int i = 0; i < REACTION_COUNT; i++) {
            if (reactions.get(i).contains(user)) {
                return reactionIndexToEnum(i);
            }
        }

        return null;
    }

    public int getReactionCount(EPostReaction reaction) {
        return reactions.get(reactionEnumToIndex(reaction)).size();
    }

    public void addReaction(User user, EPostReaction reaction) {
        removeReaction(user);
        reactions.get(reactionEnumToIndex(reaction)).add(user);
    }

    public void removeReaction(User user) {
        for (int i = 0; i < REACTION_COUNT; i++) {
            reactions.get(i).remove(user);
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
                this.getAuthor().getName(), this.getCreatedDateTime(), this.getModifiedDateTime(), this.getTags(), this.getTitle(), this.getBody());
    }

    private void nowSetModifiedDateTime() {
        this.modifiedDateTime = OffsetDateTime.now();
    }
}