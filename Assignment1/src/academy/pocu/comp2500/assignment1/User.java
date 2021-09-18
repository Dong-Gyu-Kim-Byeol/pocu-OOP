package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;

public class User {
    private final String id;

    public User(final String id) {
        assert (id.equals("") != true);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void visitBlog(final Blog blog) {
        final ArrayList<Post> filteredPosts = blog.getFilteredPostsAndSort();
        visitPrint(filteredPosts);
    }

    private void visitPrint(final ArrayList<Post> posts) {
        for (final Post post : posts) {
            System.out.println("\n-------- post --------");
            post.print();

            System.out.println("\n-------- comments --------");
            post.printComments();
        }
    }
}
