package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;

public class User {
    private String id;

    public User(String id) {
        assert (id.equals("") != true);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void visitBlog(Blog blog) {
        ArrayList<Post> filteredPosts = blog.getFilteredPostsAndSort();
        visitPrint(filteredPosts);
    }

    private void visitPrint(ArrayList<Post> posts) {
        for (Post post : posts) {
            System.out.println("\n-------- post --------");
            post.print();

            System.out.println("\n-------- comments --------");
            post.printComments();
        }
    }
}
