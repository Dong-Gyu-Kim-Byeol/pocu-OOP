package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class Blog {
    private String name;
    private LinkedList<Post> posts;

    public Blog(String name) {
        assert (name.equals("") != true);
        this.name = name;

        this.posts = new LinkedList<Post>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Post> getPosts(User authorOrNull, HashSet<String> tags) {
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

        return filteredPosts;
    }

    public void addPost(Post post) {
        this.posts.add(post);
    }

    public boolean isContainPost(Post post) {
        return posts.contains(post);
    }
}
