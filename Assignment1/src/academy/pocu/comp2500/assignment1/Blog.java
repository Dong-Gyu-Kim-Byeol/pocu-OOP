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

    public Post addPost(User author, LinkedList<String> tags, String title, String body) {
        Post newPost = new Post(author, tags, title, body);
        this.posts.add(newPost);

        return newPost;
    }

    public ArrayList<Post> getFilteredPosts(User authorOrNull, LinkedList<String> tags, EPostSorting sorting) {
        User authorFilterOrNull = authorOrNull;
        LinkedList<String> tagFilters = tags;

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

        sortingPost(sorting, filteredPosts);
        return filteredPosts;
    }

    private static void sortingPost(EPostSorting sorting, ArrayList<Post> posts) {
        switch (sorting) {
            case POST_DATE_ASCENGIND:
                Collections.sort(posts, Comparator.comparing(Post::getPostDateTime));
                break;
            case POST_DATE_DESCENGIND:
                Collections.sort(posts, Comparator.comparing(Post::getPostDateTime).reversed());
                break;
            case EDIT_DATE_ASCENGIND:
                Collections.sort(posts, Comparator.comparing(Post::getEditDateTime));
                break;
            case EDIT_DATE_DESCENGIND:
                Collections.sort(posts, Comparator.comparing(Post::getEditDateTime).reversed());
                break;
            case TITLE_ASCENGIND:
                Collections.sort(posts, Comparator.comparing(Post::getTitle));
                break;
            default:
                assert (false);
        }
    }


}
