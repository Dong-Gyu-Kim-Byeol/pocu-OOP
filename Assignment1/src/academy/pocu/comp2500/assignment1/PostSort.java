package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PostSort {
    private EPostSorting sortingType;

    public PostSort(EPostSorting sortingType) {
        this.sortingType = sortingType;
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
}
