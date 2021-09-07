package academy.pocu.comp2500.assignment1.app;

import java.util.ArrayList;
import java.util.LinkedList;

public class User {
    private String name;

    public User(String name) {
        assert (name.equals("") != true);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void visitBlog(Blog blog) {
        LinkedList<Post> posts = blog.getPosts();
        for (Post post : posts) {
            System.out.println("\n-------- post --------");
            System.out.format("title: %s, body: %s\n", post.getTitle(), post.getBody());

            System.out.println("\n-------- comments --------");
            LinkedList<PostComment> comments = post.getComments();
            for (PostComment comment : comments) {
                System.out.format("name: %s, body: %s, upvote count: %d, downvote count: %d\n", comment.getAuthorName(), comment.getBody(), comment.getUpvoteCount(), comment.getDownvoteCount());

                ArrayList<PostComment> subcomments = comment.getSubcomments();
                PostComment.printSubcommentRecursive(subcomments);
            }
        }
    }
}
