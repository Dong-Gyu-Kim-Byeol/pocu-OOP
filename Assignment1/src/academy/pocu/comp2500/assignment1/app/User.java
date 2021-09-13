package academy.pocu.comp2500.assignment1.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class User {
    private String name;
    private String authorNameFilterOrNull;
    private String tagFilterOrNull;
    private EPostSorting postSorting;

    public User(String name) {
        assert (name.equals("") != true);
        this.name = name;
        postSorting = EPostSorting.POST_DATE_ASCENGIND;
    }

    public String getName() {
        return name;
    }

    public void setAuthorFilterName(String authorNameFilterOrNull) {
        this.authorNameFilterOrNull = authorNameFilterOrNull;
    }

    public void setTagFilter(String tagFilterOrNull) {
        this.tagFilterOrNull = tagFilterOrNull;
    }

    public void setPostSorting(EPostSorting postSorting) {
        this.postSorting = postSorting;
    }

    public void visitBlog(Blog blog) {
        LinkedList<Post> posts = blog.getPosts();
        ArrayList<Post> filteredPosts = new ArrayList<Post>(posts.size());

        for (Post post : posts) {
            if (authorNameFilterOrNull != null && post.getAuthorName().equals(this.authorNameFilterOrNull) == false) {
                continue;
            }

            if (tagFilterOrNull != null && post.getTagOrNull() != null && post.getTagOrNull().equals(tagFilterOrNull) == false) {
                continue;
            }

            filteredPosts.add(post);
        }

        ArrayList<Post> sortedPosts = sortingPost(filteredPosts);
        visitPrint(sortedPosts);
    }

    private ArrayList<Post> sortingPost(ArrayList<Post> filteredPosts) {
        switch (postSorting) {
            case POST_DATE_ASCENGIND:
                filteredPosts.sort(new PostPostDateComparator());
                break;
            case POST_DATE_DESCENGIND:
                filteredPosts.sort(new PostPostDateComparator().reversed());
                break;
            case EDIT_DATE_ASCENGIND:
                filteredPosts.sort(new PostEditDateComparator());
                break;
            case EDIT_DATE_DESCENGIND:
                filteredPosts.sort(new PostEditDateComparator().reversed());
                break;
            case TITLE_ASCENGIND:
                filteredPosts.sort(new PostTitleComparator());
                break;
            default:
                assert (false);
        }

        return filteredPosts;
    }

    private void visitPrint(ArrayList<Post> posts) {
        for (Post post : posts) {
            System.out.println("\n-------- post --------");
            post.print();

            System.out.println("\n-------- comments --------");
            LinkedList<PostComment> comments = post.getComments();
            PostComment.printComments(comments);
        }
    }
}
