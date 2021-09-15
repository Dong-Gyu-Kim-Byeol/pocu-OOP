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

    public ArrayList<Post> filterPosts(HashSet<Post> posts) {
        ArrayList<Post> filteredPosts = new ArrayList<Post>(posts.size());

        for (Post post : posts) {
            // authorNameFilterOrNull
            if (getAuthorFilterOrNull() != null && post.isAuthor(getAuthorFilterOrNull()) == false) {
                continue;
            }

            // tagFilters
            if (getTagFilters().size() != 0 && post.isTagsContain(getTagFilters()) == false) {
                continue;
            }

            filteredPosts.add(post);
        }

        sortingPost(getPostSortingType(), filteredPosts);
        return filteredPosts;
    }

    public void visitBlog(HashSet<Post> posts) {
        ArrayList<Post> filteredPosts = filterPosts(posts);
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

    private void sortingPost(EPostSorting sortingType, ArrayList<Post> posts) {
        switch (sortingType) {
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
}
