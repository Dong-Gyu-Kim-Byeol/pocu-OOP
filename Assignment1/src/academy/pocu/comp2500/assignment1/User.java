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
        ArrayList<Post> filteredPosts = getPosts(blog);
        visitPrint(filteredPosts);
    }

    public ArrayList<Post> getPosts(Blog blog) {
        ArrayList<Post> filteredPosts = new ArrayList<Post>(blog.getPosts().size());

        for (Post post : blog.getPosts()) {
            // authorNameFilterOrNull
            if (getAuthorFilterOrNull() != null && post.isAuthor(authorFilterOrNull) == false) {
                continue;
            }

            // tagFilters
            if (getTagFilters().size() != 0 && post.isTagsContain(tagFilters) == false) {
                continue;
            }

            filteredPosts.add(post);
        }

        sortingPost(getPostSorting(), filteredPosts);
        return filteredPosts;
    }

    private static void sortingPost(EPostSorting sorting, ArrayList<Post> posts) {
        switch (sorting) {
            case POST_DATE_ASCENGIND:
                Collections.sort(posts, Comparator.comparing(Post::getCreatedDateTime));
                break;
            case POST_DATE_DESCENGIND:
                Collections.sort(posts, Comparator.comparing(Post::getCreatedDateTime).reversed());
                break;
            case EDIT_DATE_ASCENGIND:
                Collections.sort(posts, Comparator.comparing(Post::getModifiedDateTime));
                break;
            case EDIT_DATE_DESCENGIND:
                Collections.sort(posts, Comparator.comparing(Post::getModifiedDateTime).reversed());
                break;
            case TITLE_ASCENGIND:
                Collections.sort(posts, Comparator.comparing(Post::getTitle));
                break;
            default:
                assert (false);
        }
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
