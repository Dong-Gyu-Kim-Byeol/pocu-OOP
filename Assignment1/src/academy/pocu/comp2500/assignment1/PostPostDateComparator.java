package academy.pocu.comp2500.assignment1;

import java.util.Comparator;

public class PostPostDateComparator implements Comparator<Post> {
    @Override
    public int compare(Post p1, Post p2) {
        return p1.getPostDateTime().compareTo(p2.getPostDateTime());
    }
}
