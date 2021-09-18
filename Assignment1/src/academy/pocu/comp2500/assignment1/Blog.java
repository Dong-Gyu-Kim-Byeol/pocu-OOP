package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class Blog {
    private String name;

    private final HashSet<Post> posts;

    private String authorIdFilterOrNull;
    private HashSet<String> tagsFilter;
    private EPostSorting sortingType;

    public Blog(String name) {
        this.name = name;

        this.posts = new HashSet<Post>();

        this.tagsFilter = new HashSet<String>();
        this.sortingType = EPostSorting.POST_DATE_DESCENGIND;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public ArrayList<Post> getFilteredPostsAndSort() {
        final ArrayList<Post> filteredPosts = new ArrayList<Post>(this.posts.size());

        for (final Post post : this.posts) {
            // authorFilter
            if (authorIdFilterOrNull != null && post.isAuthor(authorIdFilterOrNull) == false) {
                continue;
            }

            // tagFilter
            if (tagsFilter.size() != 0 && post.isTagsContainEvenOne(tagsFilter) == false) {
                continue;
            }

            sorting(filteredPosts);
            filteredPosts.add(post);
        }

        return filteredPosts;
    }

    public void setAuthorIdFilterOrNull(final String authorIdOrNull) {
        this.authorIdFilterOrNull = authorIdOrNull;
    }

    public void setTagsFilter(final HashSet<String> tags) {
        tagsFilter = tags;
    }

    public void setSortingType(final EPostSorting sortingType) {
        this.sortingType = sortingType;
    }

    public void sorting(final ArrayList<Post> posts) {
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

    public void addPost(final Post post) {
        this.posts.add(post);
    }
}
