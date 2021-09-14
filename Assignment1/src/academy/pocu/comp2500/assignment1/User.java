package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;
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

    public User getAuthorFilterOrNull() {
        return authorFilterOrNull;
    }

    public void setAuthorFilter(User authorOrNull) {
        this.authorFilterOrNull = authorOrNull;
    }

    public LinkedList<String> getTagFilters() {
        return tagFilters;
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
        ArrayList<Post> filteredPosts = blog.getFilteredPosts(this);
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
