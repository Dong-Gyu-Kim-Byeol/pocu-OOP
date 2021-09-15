package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class Blog {
    private String name;
    private HashSet<Post> posts;

    private AuthorFilter authorFilter;
    private TagFilter tagFilter;
    private PostSort postSort;

    public Blog(String name, AuthorFilter authors, TagFilter tags, PostSort sort) {
        assert (name.equals("") != true);
        this.name = name;

        this.posts = new HashSet<Post>();

        this.authorFilter = authors;
        this.tagFilter = tags;
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

    public ArrayList<Post> getFilteredPostsAndSort() {
        ArrayList<Post> filteredPosts = new ArrayList<Post>(getPosts().size());

        for (Post post : getPosts()) {
            // authorNameFilterOrNull
            if (getAuthorsFilter().size() != 0 && getAuthorsFilter().contains(post.getAuthor()) == false) {
                continue;
            }

            // tagFilters
            if (getTagsFilter().size() != 0 && post.isTagsContain(getTagsFilter()) == false) {
                continue;
            }

            sorting(filteredPosts);
            filteredPosts.add(post);
        }

        return filteredPosts;
    }

    public PostSort getPostSort() {
        return postSort;
    }

    public void sorting(ArrayList<Post> posts) {
        getPostSort().sorting(posts);
    }

    public HashSet<User> getAuthorsFilter() {
        return authorFilter.getAuthorsFilter();
    }

    public void setAuthorsFilter(HashSet<User> authors) {
        authorFilter.setAuthorsFilter(authors);
    }

    public HashSet<String> getTagsFilter() {
        return tagFilter.getTagsFilter();
    }

    public void setTagsFilter(HashSet<String> tags) {
        tagFilter.setTagsFilter(tags);
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
