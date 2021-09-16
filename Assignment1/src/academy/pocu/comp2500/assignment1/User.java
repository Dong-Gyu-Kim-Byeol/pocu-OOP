package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;

public class User {
    private Blog blog;
    private int userId;
    private String name;

    public User(Blog blog, int userId, String name) {
        this.blog = blog;

        this.userId = userId;

        assert (name.equals("") != true);
        this.name = name;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
