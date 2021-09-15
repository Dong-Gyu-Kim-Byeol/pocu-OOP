package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class Blog {
    private String name;
    private HashSet<Post> posts;

    private User authorFilterOrNull;
    private HashSet<String> tagsFilter;
    private EPostSorting sortingType;

    public Blog(String name) {
        assert (name.equals("") != true);
        this.name = name;

        this.posts = new HashSet<Post>();

        this.tagsFilter = new HashSet<String>();
        this.sortingType = EPostSorting.POST_DATE_DESCENGIND;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashSet<Post> getPosts() {
        return posts;
    }

    public ArrayList<Post> getFilteredPostsAndSort() {
        ArrayList<Post> filteredPosts = new ArrayList<Post>(getPosts().size());

        for (Post post : getPosts()) {
            // authorFilter
            if (getAuthorFilterOrNull() != null && post.isAuthor(getAuthorFilterOrNull()) == false) {
                continue;
            }

            // tagFilter
            if (getTagsFilter().size() != 0 && post.isTagsContain(getTagsFilter()) == false) {
                continue;
            }

            sorting(filteredPosts);
            filteredPosts.add(post);
        }

        return filteredPosts;
    }

    public User getAuthorFilterOrNull() {
        return authorFilterOrNull;
    }

    public void setAuthorFilterOrNull(User authorOrNull) {
        this.authorFilterOrNull = authorOrNull;
    }

    public HashSet<String> getTagsFilter() {
        return tagsFilter;
    }

    public void setTagsFilter(HashSet<String> tags) {
        tagsFilter = tags;
    }

    public void setSortingType(EPostSorting sortingType) {
        this.sortingType = sortingType;
    }

    public void sorting(ArrayList<Post> posts) {
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


    public void addPost(Post post) {
        this.posts.add(post);
    }

    public boolean isContainPost(Post post) {
        return posts.contains(post);
    }


}
