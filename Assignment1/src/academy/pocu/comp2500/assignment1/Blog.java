package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class Blog {
    private String name;
    private HashSet<Post> posts;

    private HashSet<User> authorFilters;
    private HashSet<String> tagFilters;
    private EPostSorting postSortingType;

    public Blog(String name) {
        assert (name.equals("") != true);
        this.name = name;

        this.posts = new HashSet<Post>();

        authorFilters = new HashSet<User>();
        tagFilters = new HashSet<String>();
        postSortingType = EPostSorting.POST_DATE_ASCENGIND;
    }

    public void setAuthorFilters(HashSet<User> authors) {
        this.authorFilters = authors;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Post> getPosts() {
        ArrayList<Post> filteredPosts = new ArrayList<Post>(this.getPosts().size());

        for (Post post : getPosts()) {
            // authorNameFilterOrNull
            if (authorFilters.size() != 0 && authorFilters.contains(post.getAuthor()) == false) {
                continue;
            }

            // tagFilters
            if (tagFilters.size() != 0 && post.isTagsContain(tagFilters) == false) {
                continue;
            }

            filteredPosts.add(post);
        }

        sortingPost(getPostSortingType(), filteredPosts);
        return filteredPosts;
    }

    public void addPost(Post post) {
        this.getPosts().add(post);
    }

    public boolean isContainPost(Post post) {
        return getPosts().contains(post);
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
