package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;

public class Blog {
    private String name;

    private int userIdCount;
    private HashMap<Integer, User> userMap;

    private HashSet<Post> posts;

    private int authorIdFilter;
    private HashSet<String> tagsFilter;
    private EPostSorting sortingType;

    public Blog(String name) {
        this.name = name;
        this.userMap = new HashMap<Integer, User>();

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

    public User getUserOrNull(int userId) {
        return this.userMap.get(userId);
    }

    public User createUser(String name) {
        int newUserId = getNewUserId();
        User newUser = new User(newUserId, name);

        this.userMap.put(newUser.getUserId(), newUser);

        return newUser;
    }

    public HashSet<Post> getPosts() {
        return posts;
    }

    public ArrayList<Post> getFilteredPostsAndSort() {
        ArrayList<Post> filteredPosts = new ArrayList<Post>(getPosts().size());

        for (Post post : getPosts()) {
            // authorFilter
            if (getAuthorIdFilter() <= 0 && post.isAuthor(getAuthorIdFilter()) == false) {
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

    public int getAuthorIdFilter() {
        return authorIdFilter;
    }

    public void setAuthorIdFilter(int authorId) {
        this.authorIdFilter = authorId;
    }

    public HashSet<String> getTagsFilter() {
        return tagsFilter;
    }

    public void setTagsFilter(HashSet<String> tags) {
        tagsFilter = tags;
    }

    public EPostSorting getSortingType() {
        return sortingType;
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

    private int getNewUserId() {
        userIdCount++;
        while (true) {
            if (userIdCount <= 0) {
                userIdCount = 1;
            }

            if (userMap.containsKey(userIdCount)) {
                userIdCount++;
                continue;
            }

            assert (isValidUserId(userIdCount) == true);
            return userIdCount;
        }
    }

    private boolean isValidUserId(int id) {
        if (userIdCount <= 0) {
            return false;
        }

        if (userMap.containsKey(userIdCount) == true) {
            return false;
        }

        return true;
    }
}
