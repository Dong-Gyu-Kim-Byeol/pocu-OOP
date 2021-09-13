package academy.pocu.comp2500.assignment1;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class Post {
    private User author;
    private String tagOrNull;

    private LocalDateTime postDateTime;
    private LocalDateTime editDateTime;
    private String title;
    private String body;
    private LinkedList<PostComment> comments;

    private LinkedList<User> greatReactions;
    private LinkedList<User> sadReactions;
    private LinkedList<User> angryReactions;
    private LinkedList<User> funReactions;
    private LinkedList<User> loveReactions;


    public Post(User author, String title, String body) {
        this.author = author;

        assert (title.equals("") != true);
        this.title = title;

        assert (body.equals("") != true);
        this.body = body;

        this.postDateTime = LocalDateTime.now();
        this.editDateTime = LocalDateTime.now();

        comments = new LinkedList<PostComment>();

        greatReactions = new LinkedList<User>();
        sadReactions = new LinkedList<User>();
        angryReactions = new LinkedList<User>();
        funReactions = new LinkedList<User>();
        loveReactions = new LinkedList<User>();
    }

    public String getAuthorName() {
        return author.getName();
    }

    public String getTagOrNull() {
        return this.tagOrNull;
    }

    public void setTag(String tagOrNull) {
        this.tagOrNull = tagOrNull;
        this.editDateTime = LocalDateTime.now();
    }

    public LocalDateTime getPostDateTime() {
        return postDateTime;
    }

    public LocalDateTime getEditDateTime() {
        return editDateTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        assert (title.equals("") != true);
        this.title = title;
        this.editDateTime = LocalDateTime.now();
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        assert (body.equals("") != true);
        this.body = body;
        this.editDateTime = LocalDateTime.now();
    }


    public LinkedList<PostComment> getComments() {
        return comments;
    }

    public PostComment addComment(User author, String body) {
        PostComment newComment = new PostComment(author, body);
        this.comments.add(newComment);

        return newComment;
    }

    public void addReaction(User user, EPostReaction reactionType) {
        switch (reactionType) {
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

    public void print() {
        System.out.format("author: %s, post date: %s, edit date: %s,, tag: %s, title: %s, body: %s\n", this.getAuthorName(), this.getPostDateTime(), this.getEditDateTime(), this.getTagOrNull(), this.getTitle(), this.getBody());
    }
}