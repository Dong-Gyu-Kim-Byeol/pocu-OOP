package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

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
        ArrayList<Post> filteredPosts = blog.getPosts();
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
