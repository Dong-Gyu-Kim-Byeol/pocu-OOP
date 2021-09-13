package academy.pocu.comp2500.assignment1;

import java.util.Comparator;

public class PostEditDateComparator implements Comparator<Post> {
    @Override
    public int compare(Post p1, Post p2) {
        return p1.getEditDateTime().compareTo(p2.getEditDateTime());
    }
}