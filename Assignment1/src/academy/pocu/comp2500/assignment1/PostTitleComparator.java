package academy.pocu.comp2500.assignment1;

import java.util.Comparator;

public class PostTitleComparator implements Comparator<Post> {
    @Override
    public int compare(Post p1, Post p2) {
        return p1.getTitle().compareTo(p2.getTitle());
    }
}
