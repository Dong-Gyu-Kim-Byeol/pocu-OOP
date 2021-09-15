package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class Blog {
    private String name;
    private HashSet<Post> posts;

    private PostFilter postFilter;
    private PostSort postSort;

    public Blog(String name, PostFilter at, PostSort sort) {
        assert (name.equals("") != true);
        this.name = name;

        this.posts = new HashSet<Post>();

        this.postFilter = at;
        this.postSort = sort;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashSet<Post> getPosts() {
        return posts;
    }

    public ArrayList<Post> getPostsAtPostFilterAndSort() {
        ArrayList<Post> filteredPosts = getPostFilter().getPosts(this);
        getPostSort().sorting(filteredPosts);
        return filteredPosts;
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


    public void addPost(Post post) {
        this.posts.add(post);
    }

    public boolean isContainPost(Post post) {
        return posts.contains(post);
    }


}
