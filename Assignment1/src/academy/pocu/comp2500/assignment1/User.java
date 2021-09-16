package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;

public class User {
    private String name;

    public User(String name) {
        assert (name.equals("") != true);
        this.name = name;
    }

    public boolean equals(User user) {
        if (user == this) {
            return true;
        }

        return this.name.equals(user.getName());
    }

//    @Override
//    public boolean equals(Object other) {
//        if (other == this) {
//            return true;
//        }
//
//        if ((other instanceof User) == false) {
//            return false;
//        }
//
//        User otherUser = (User) other;
//        return this.name.equals(otherUser.getName());
//    }
//
//    @Override
//    public int hashCode() {
//        final int PRIME = 31;
//        int hash = 1;
//
//        //        hash = PRIME * hash + (int) (id ^ (id >>> 32));
//        hash = PRIME * hash + name.hashCode();
//
//        return hash;
//    }

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
