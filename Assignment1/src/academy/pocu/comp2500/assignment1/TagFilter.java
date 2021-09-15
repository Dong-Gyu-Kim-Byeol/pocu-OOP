package academy.pocu.comp2500.assignment1;

import java.util.HashSet;

public class TagFilter {
    private HashSet<String> tagFilters;

    public TagFilter() {
        this.tagFilters = new HashSet<String>();
    }

    public HashSet<String> getTagsFilter() {
        return tagFilters;
    }

    public void setTagsFilter(HashSet<String> tags) {
        this.tagFilters = tags;
    }
}
