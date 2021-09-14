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

    private HashSet<User> greatReactions;
    private HashSet<User> sadReactions;
    private HashSet<User> angryReactions;
    private HashSet<User> funReactions;
    private HashSet<User> loveReactions;

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
        nowSetModifiedDateTime();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(User author, String title) {
        if (isAuthor(author) == false) {
            return;
        }

        if (title.equals("")) {
            return;
        }

        this.title = title;
        nowSetModifiedDateTime();
    }

    public String getBody() {
        return body;
    }

    public void setBody(User author, String body) {
        if (isAuthor(author) == false) {
            return;
        }

        if (title.equals("")) {
            return;
        }

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
        sortComments();
        return comments;
    }

    public void addComment(PostComment comment) {
        this.comments.add(comment);
    }

    public HashSet<User> getReactionsOrNull(EPostReaction reaction) {
        switch (reaction) {
            case GREAT:
                return this.greatReactions;
            case SAD:
                return this.sadReactions;
            case ANGRY:
                return this.angryReactions;
            case FUN:
                return this.funReactions;
            case LOVE:
                return this.loveReactions;
            default:
                assert (false);
                return null;
        }
    }

    public void addReaction(User user, EPostReaction reaction) {
        switch (reaction) {
            case GREAT:
                if (this.greatReactions.contains(user) != true) {
                    this.greatReactions.add(user);
                }
                break;
            case SAD:
                if (this.sadReactions.contains(user) != true) {
                    this.sadReactions.add(user);
                }
                break;
            case ANGRY:
                if (this.angryReactions.contains(user) != true) {
                    this.angryReactions.add(user);
                }
                break;
            case FUN:
                if (this.funReactions.contains(user) != true) {
                    this.funReactions.add(user);
                }
                break;
            case LOVE:
                if (this.loveReactions.contains(user) != true) {
                    this.loveReactions.add(user);
                }
                break;
            default:
                assert (false);
        }
    }

    public void deleteReaction(User user) {
        if (this.greatReactions.contains(user) == true) {
            this.greatReactions.remove(user);
            return;
        }

        if (this.sadReactions.contains(user) == true) {
            this.sadReactions.remove(user);
            return;
        }

        if (this.angryReactions.contains(user) == true) {
            this.angryReactions.remove(user);
            return;
        }

        if (this.funReactions.contains(user) == true) {
            this.funReactions.remove(user);
            return;
        }

        if (this.loveReactions.contains(user) == true) {
            this.loveReactions.remove(user);
            return;
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

    private void sortComments() {
        Collections.sort(comments, Comparator.comparing(PostComment::getVoteScore).reversed());
    }
}