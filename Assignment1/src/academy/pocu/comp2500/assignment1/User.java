package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class User {
    private String name;
    private PostFilter postFilter;

    public User(String name) {
        assert (name.equals("") != true);
        this.name = name;
        this.postFilter = new PostFilter();
    }

    public String getName() {
        return name;
    }

    public PostFilter getPostFilter() {
        return postFilter;
    }

    public void setAuthorFilters(HashSet<User> authorFilters) {
        getPostFilter().setAuthorFilters(authorFilters);
    }

    public void setTagFilters(HashSet<String> tagFilters) {
        getPostFilter().setTagFilters(tagFilters);
    }

    public void setPostSortingType(EPostSorting postSortingType) {
        getPostFilter().setPostSortingType(postSortingType);
    }

    public ArrayList<Post> getPosts(Blog blog) {
        return getPostFilter().getPosts(blog);
    }

    public void visitBlog(Blog blog) {
        ArrayList<Post> filteredPosts = getPosts(blog);
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
