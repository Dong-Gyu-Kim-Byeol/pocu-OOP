package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class User {
    private String name;
    private User authorFilterOrNull;
    private HashSet<String> tagFiltersOrNull;
    private EPostSorting postSorting;

    public User(String name) {
        assert (name.equals("") != true);
        this.name = name;

        postSorting = EPostSorting.POST_DATE_ASCENGIND;
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

    public HashSet<String> getTagFiltersOrNull() {
        return tagFiltersOrNull;
    }

    public void setTagFiltersOrNull(HashSet<String> tagsOrNull) {
        this.tagFiltersOrNull = tagsOrNull;
    }

    public EPostSorting getPostSorting() {
        return postSorting;
    }

    public void setPostSorting(EPostSorting sorting) {
        this.postSorting = sorting;
    }

    public void visitBlog(Blog blog) {
        ArrayList<Post> filteredPosts = blog.getPosts(getAuthorFilterOrNull(), getTagFiltersOrNull(), getPostSorting());
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
