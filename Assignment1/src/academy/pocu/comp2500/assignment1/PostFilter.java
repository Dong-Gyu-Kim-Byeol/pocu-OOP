package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class PostFilter {
    private HashSet<User> authorFilters;
    private HashSet<String> tagFilters;
    private EPostSorting postSortingType;

    public PostFilter() {
        this.authorFilters = new HashSet<User>();
        this.tagFilters = new HashSet<String>();
        this.postSortingType = EPostSorting.POST_DATE_ASCENGIND;
    }

    public HashSet<User> getAuthorFilters() {
        return authorFilters;
    }

    public void setAuthorFilters(HashSet<User> authorFilters) {
        this.authorFilters = authorFilters;
    }

    public HashSet<String> getTagFilters() {
        return tagFilters;
    }

    public void setTagFilters(HashSet<String> tagFilters) {
        this.tagFilters = tagFilters;
    }

    public EPostSorting getPostSortingType() {
        return postSortingType;
    }

    public void setPostSortingType(EPostSorting postSortingType) {
        this.postSortingType = postSortingType;
    }

    public ArrayList<Post> getPosts(Blog blog) {
        ArrayList<Post> filteredPosts = new ArrayList<Post>(blog.getPosts().size());

        for (Post post : blog.getPosts()) {
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
