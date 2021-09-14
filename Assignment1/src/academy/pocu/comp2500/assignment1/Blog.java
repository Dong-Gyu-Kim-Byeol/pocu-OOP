package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;

public class Blog {
    private String name;
    private HashSet<Post> posts;

    public Blog(String name) {
        assert (name.equals("") != true);
        this.name = name;

        this.posts = new HashSet<Post>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Post> getPosts(User authorOrNull, HashSet<String> tags, EPostSorting sortingType) {
        ArrayList<Post> filteredPosts = new ArrayList<Post>(this.posts.size());

        for (Post post : posts) {
            // authorNameFilterOrNull
            if (authorOrNull != null && post.isAuthor(authorOrNull) == false) {
                continue;
            }

            // tagFilters
            if (tags.size() != 0 && post.isTagsContain(tags) == false) {
                continue;
            }

            filteredPosts.add(post);
        }

        sortingPost(sortingType, filteredPosts);
        return filteredPosts;
    }

    public void addPost(Post post) {
        this.posts.add(post);
    }

    public boolean isContainPost(Post post) {
        return posts.contains(post);
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
