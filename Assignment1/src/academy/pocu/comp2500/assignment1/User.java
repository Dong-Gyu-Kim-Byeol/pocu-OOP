package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;
import java.util.HashSet;

public class User {
    private int userId;
    private String name;

    private static int userIdCount = 0;
    private static HashSet<Integer> userIdSet = new HashSet<Integer>();

    public User(String name) {
        this.userId = getNewId();

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

    private static int getNewId() {
        userIdCount++;
        while (true) {
            if (userIdCount <= 0) {
                userIdCount = 1;
            }

            if (userIdSet.contains(userIdCount)) {
                userIdCount++;
                continue;
            }

            return userIdCount;
        }
    }
}
