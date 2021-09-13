package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class User {
    private String name;
    private String authorNameFilterOrNull;
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

    public void setAuthorNameFilter(String authorNameOrNull) {
        this.authorNameFilterOrNull = authorNameOrNull;
    }

    public void setTagFilters(LinkedList<String> tags) {
        this.tagFilters = tags;
    }

    public void setPostSorting(EPostSorting sorting) {
        this.postSorting = sorting;
    }

    public void visitBlog(Blog blog) {
        ArrayList<Post> filteredPosts = blog.getPosts(authorNameFilterOrNull, tagFilters);
        ArrayList<Post> sortedPosts = sortingPost(filteredPosts);
        visitPrint(sortedPosts);
    }

    private ArrayList<Post> sortingPost(ArrayList<Post> filteredPosts) {
        switch (postSorting) {
            case POST_DATE_ASCENGIND:
                Collections.sort(filteredPosts, Comparator.comparing(Post::getPostDateTime));
                break;
            case POST_DATE_DESCENGIND:
                Collections.sort(filteredPosts, Comparator.comparing(Post::getPostDateTime).reversed());
                break;
            case EDIT_DATE_ASCENGIND:
                Collections.sort(filteredPosts, Comparator.comparing(Post::getEditDateTime));
                break;
            case EDIT_DATE_DESCENGIND:
                Collections.sort(filteredPosts, Comparator.comparing(Post::getEditDateTime).reversed());
                break;
            case TITLE_ASCENGIND:
                Collections.sort(filteredPosts, Comparator.comparing(Post::getTitle));
                break;
            default:
                assert (false);
        }

        return filteredPosts;
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
