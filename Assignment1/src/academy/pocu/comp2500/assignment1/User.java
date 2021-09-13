package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class User {
    private String name;
    private User authorFilterOrNull;
    private LinkedList<String> tagFilters;
    private EPostSorting postSorting;

    public User(String name) {
        assert (name.equals("") != true);
        this.name = name;

        tagFilters = new LinkedList<String>();

        postSorting = EPostSorting.POST_DATE_ASCENGIND;
    }

    public String getName() {
        return name;
    }

    public void setAuthorFilter(User authorOrNull) {
        this.authorFilterOrNull = authorOrNull;
    }

    public void setTagFilters(LinkedList<String> tags) {
        this.tagFilters = tags;
    }

    public EPostSorting getPostSorting() {
        return postSorting;
    }

    public void setPostSorting(EPostSorting sorting) {
        this.postSorting = sorting;
    }

    public void visitBlog(Blog blog) {
        ArrayList<Post> filteredPosts = blog.getFilteredPosts(authorFilterOrNull, tagFilters, postSorting);
        visitPrint(filteredPosts);
    }

    private void visitPrint(ArrayList<Post> posts) {
        for (Post post : posts) {
            System.out.println("\n-------- post --------");
            post.print();

            System.out.println("\n-------- comments --------");
            LinkedList<PostComment> comments = post.getComments();
            PostComment.printComments(comments);
        }
    }
}
