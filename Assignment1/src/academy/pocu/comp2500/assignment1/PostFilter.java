package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class PostFilter {
    private HashSet<User> authorFilters;
    private HashSet<String> tagFilters;

    public PostFilter() {
        this.authorFilters = new HashSet<User>();
        this.tagFilters = new HashSet<String>();
    }

    public HashSet<User> getAuthorFilters() {
        return authorFilters;
    }

    public void setAuthorFilters(HashSet<User> authors) {
        this.authorFilters = authors;
    }

    public HashSet<String> getTagFilters() {
        return tagFilters;
    }

    public void setTagFilters(HashSet<String> tags) {
        this.tagFilters = tags;
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

        return filteredPosts;
    }


}
