package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class User {
    private String name;
    private User authorFilterOrNull;
    private HashSet<String> tagFilters;
    private EPostSorting postSortingType;

    public User(String name) {
        assert (name.equals("") != true);
        this.name = name;

        tagFilters = new HashSet<String>();
        postSortingType = EPostSorting.POST_DATE_ASCENGIND;
    }

    public String getName() {
        return name;
    }

    public User getAuthorFilterOrNull() {
        return authorFilterOrNull;
    }

    public void setAuthorFilterOrNull(User authorOrNull) {
        this.authorFilterOrNull = authorOrNull;
    }

    public HashSet<String> getTagFilters() {
        return tagFilters;
    }

    public void setTagFilters(HashSet<String> tags) {
        this.tagFilters = tags;
    }

    public EPostSorting getPostSortingType() {
        return postSortingType;
    }

    public void setPostSortingType(EPostSorting sortingType) {
        this.postSortingType = sortingType;
    }

    public void visitBlog(Blog blog) {
        ArrayList<Post> filteredPosts = blog.getFilteredPosts(getAuthorFilterOrNull(), getTagFilters(), getPostSortingType());
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
