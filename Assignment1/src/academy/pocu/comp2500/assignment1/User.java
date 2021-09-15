package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class User {
    private String name;
    private PostFilter postFilter;
    private PostSort postSort;

    public User(String name) {
        assert (name.equals("") != true);
        this.name = name;

        this.postFilter = new PostFilter();
        this.postSort = new PostSort(EPostSorting.POST_DATE_ASCENGIND);
    }

    public String getName() {
        return name;
    }

    public PostFilter getPostFilter() {
        return postFilter;
    }

    public PostSort getPostSort() {
        return postSort;
    }

    public void setAuthorFilters(HashSet<User> authors) {
        getPostFilter().setAuthorFilters(authors);
    }

    public void setTagFilters(HashSet<String> tags) {
        getPostFilter().setTagFilters(tags);
    }

    public void setSortingType(EPostSorting sortingType) {
        getPostSort().setSortingType(sortingType);
    }

    public ArrayList<Post> getPosts(Blog blog) {
        ArrayList<Post> filteredPosts = getPostFilter().getPosts(blog);
        getPostSort().sorting(filteredPosts);
        return filteredPosts;
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
