package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Blog {
    private String name;
    private LinkedList<Post> posts;

    public Blog(String name) {
        assert (name.equals("") != true);
        this.name = name;

        this.posts = new LinkedList<Post>();
    }

    public void addPost(Post post) {
        this.posts.add(post);
    }

    public ArrayList<Post> getFilteredPosts(User user) {
        User authorFilterOrNull = user.getAuthorFilterOrNull();
        LinkedList<String> tagFilters = user.getTagFilters();

        ArrayList<Post> filteredPosts = new ArrayList<Post>(posts.size());

        for (Post post : posts) {
            // authorNameFilterOrNull
            if (authorFilterOrNull != null && post.isAuthor(authorFilterOrNull) == false) {
                continue;
            }

            // tagFilters
            if (tagFilters.size() != 0 && post.isTagsContain(tagFilters) == false) {
                continue;
            }

            filteredPosts.add(post);
        }

        sortingPost(user.getPostSorting(), filteredPosts);
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


}
