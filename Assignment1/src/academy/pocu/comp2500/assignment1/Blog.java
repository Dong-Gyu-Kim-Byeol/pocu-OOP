package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;
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

    public Post addPost(User author, String title, String body) {
        Post newPost = new Post(author, title, body);
        this.posts.add(newPost);

        return newPost;
    }

    public ArrayList<Post> getPosts(String authorNameOrNull, LinkedList<String> tagFilters) {
        ArrayList<Post> filteredPosts = new ArrayList<Post>(posts.size());

        for (Post post : posts) {
            if (authorNameOrNull != null && post.getAuthorName().equals(authorNameOrNull) == false) {
                continue;
            }

            for (String tagFilter : tagFilters) {
                if (post.getTags().contains(tagFilter) == false) {
                    continue;
                }
            }

            filteredPosts.add(post);
        }

        return filteredPosts;
    }


}
