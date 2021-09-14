package academy.pocu.comp2500.assignment1;

import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Post {
    private User author;
    private LinkedList<String> tags;

    private OffsetDateTime createdDateTime;
    private OffsetDateTime modifiedDateTime;
    private String title;
    private String body;
    private LinkedList<PostComment> comments;

    private LinkedList<User> greatReactions;
    private LinkedList<User> sadReactions;
    private LinkedList<User> angryReactions;
    private LinkedList<User> funReactions;
    private LinkedList<User> loveReactions;

    public Post(User author, LinkedList<String> tags, String title, String body) {
        this.author = author;

        this.tags = tags;

        assert (title.equals("") != true);
        this.title = title;

        assert (body.equals("") != true);
        this.body = body;

        this.createdDateTime = OffsetDateTime.now();
        this.modifiedDateTime = createdDateTime;

        comments = new LinkedList<PostComment>();

        greatReactions = new LinkedList<User>();
        sadReactions = new LinkedList<User>();
        angryReactions = new LinkedList<User>();
        funReactions = new LinkedList<User>();
        loveReactions = new LinkedList<User>();
    }

    public OffsetDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public OffsetDateTime getModifiedDateTime() {
        return modifiedDateTime;
    }

    public String getAuthorName() {
        return author.getName();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        assert (title.equals("") != true);
        this.title = title;
        nowSetModifiedDateTime();
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        assert (body.equals("") != true);
        this.body = body;
        nowSetModifiedDateTime();
    }

    public boolean isAuthor(User user) {
        if (this.author == user) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isTagsContain(LinkedList<String> tags) {
        for (String tag : tags) {
            if (this.getTags().contains(tag) == false) {
                return false;
            }
        }
        return true;
    }

    public void addTag(String tag) {
        if (tag.equals("")) {
            return;
        }

        this.tags.add(tag);
        nowSetModifiedDateTime();
    }

    public PostComment addComment(User author, String body) {
        PostComment newComment = new PostComment(author, body);
        this.comments.add(newComment);

        return newComment;
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
                this.getAuthorName(), this.getCreatedDateTime(), this.getModifiedDateTime(), this.getTags(), this.getTitle(), this.getBody());
    }

    private void nowSetModifiedDateTime() {
        this.modifiedDateTime = OffsetDateTime.now();
    }

    private LinkedList<String> getTags() {
        return this.tags;
    }

    private LinkedList<PostComment> getComments() {
        sortCcomments();
        return comments;
    }

    private void sortCcomments() {
        Collections.sort(comments, Comparator.comparing(PostComment::getVoteScore).reversed());
    }
}