package academy.pocu.comp2500.lab4;

import java.util.ArrayList;
import java.util.HashMap;

public class MemoryCache {
    private static int maxInstanceCount;
    private static HashMap<String, MemoryCache> instances;
    private static ArrayList<String> leastRecentlyUsedDiskNames;

    //    private final String diskName;
    private EvictionPolicy evictionPolicy;
    private int maxEntryCount;
    private final HashMap<String, String> entries;
    private final ArrayList<String> inputSortedEntries;
    private final ArrayList<String> leastRecentlyUsedSortedEntries;


    // static public
    public static void setMaxInstanceCount(final int maxInstanceCount) {
        assert (maxInstanceCount > 0);

        MemoryCache.maxInstanceCount = maxInstanceCount;
        MemoryCache.instancesCountCheckAndRemove();
    }

    public static MemoryCache getInstance(final String diskName) {
        if (instances == null) {
            MemoryCache.maxInstanceCount = 3;
            MemoryCache.instances = new HashMap<String, MemoryCache>(MemoryCache.maxInstanceCount);
            MemoryCache.leastRecentlyUsedDiskNames = new ArrayList<String>(MemoryCache.maxInstanceCount);
        }

        assert (MemoryCache.leastRecentlyUsedDiskNames.size() == MemoryCache.instances.size());

        if (MemoryCache.instances.containsKey(diskName)) {
            MemoryCache.updateLeastRecentlyUsedSortedDiskNames(diskName);
            return MemoryCache.instances.get(diskName);
        } else {
            final MemoryCache newMemoryCache = new MemoryCache();
            MemoryCache.instances.put(diskName, newMemoryCache);
            MemoryCache.updateLeastRecentlyUsedSortedDiskNames(diskName);

            MemoryCache.instancesCountCheckAndRemove();

            return newMemoryCache;
        }
    }

    public static void clear() {
        MemoryCache.instances.clear();
        MemoryCache.leastRecentlyUsedDiskNames.clear();
    }


    // public
    public void setEvictionPolicy(final EvictionPolicy evictionPolicy) {
        this.evictionPolicy = evictionPolicy;
    }

    public void setMaxEntryCount(final int maxEntryCount) {
        assert (maxEntryCount > 0);
        this.maxEntryCount = maxEntryCount;

        this.entriesCountCheckAndRemove(false);
    }

    public void addEntry(final String key, final String value) {
        assert (this.inputSortedEntries.size() == this.leastRecentlyUsedSortedEntries.size());
        assert (this.inputSortedEntries.size() == this.entries.size());

        if (this.entries.containsKey(key)) {
            this.entries.put(key, value);
            this.updateLeastRecentlyUsedSortedEntries(key);
        } else {
            this.entries.put(key, value);
            this.inputSortedEntries.add(key);
            this.leastRecentlyUsedSortedEntries.add(key);
            this.entriesCountCheckAndRemove(true);
        }

        assert (this.inputSortedEntries.size() == this.leastRecentlyUsedSortedEntries.size());
        assert (this.inputSortedEntries.size() == this.entries.size());

//        MemoryCache.updateLeastRecentlyUsedSortedDiskNames(this.diskName);
    }

    public String getEntryOrNull(final String key) {
        if (this.entries.containsKey(key)) {
//            MemoryCache.updateLeastRecentlyUsedSortedDiskNames(this.diskName);
            this.updateLeastRecentlyUsedSortedEntries(key);
            return this.entries.get(key);
        } else {
            return null;
        }
    }


    // static private
    private static void updateLeastRecentlyUsedSortedDiskNames(final String diskName) {
        MemoryCache.leastRecentlyUsedDiskNames.remove(diskName);
        MemoryCache.leastRecentlyUsedDiskNames.add(diskName);
    }

    private static void instancesCountCheckAndRemove() {
        assert (MemoryCache.leastRecentlyUsedDiskNames.size() == MemoryCache.instances.size());

        while (MemoryCache.instances.size() > MemoryCache.maxInstanceCount) {
            MemoryCache.instances.remove(MemoryCache.leastRecentlyUsedDiskNames.get(0));
            MemoryCache.leastRecentlyUsedDiskNames.remove(0);
        }
    }


    // private
    private MemoryCache() {
//        this.diskName = diskName;
        this.evictionPolicy = EvictionPolicy.LEAST_RECENTLY_USED;
        this.maxEntryCount = 5;
        this.entries = new HashMap<String, String>(this.maxEntryCount);
        this.inputSortedEntries = new ArrayList<String>(this.maxEntryCount);
        this.leastRecentlyUsedSortedEntries = new ArrayList<String>(this.maxEntryCount);
    }

    private void updateLeastRecentlyUsedSortedEntries(final String key) {
        assert (this.leastRecentlyUsedSortedEntries.contains(key));

        this.leastRecentlyUsedSortedEntries.remove(key);
        this.leastRecentlyUsedSortedEntries.add(key);
    }

    private void entriesCountCheckAndRemove(final boolean isAfterAdd) {
        assert (this.inputSortedEntries.size() == this.leastRecentlyUsedSortedEntries.size());
        assert (this.inputSortedEntries.size() == this.entries.size());

        while (this.entries.size() > this.maxEntryCount) {
            switch (this.evictionPolicy) {
                case FIRST_IN_FIRST_OUT:
                    this.entries.remove(this.inputSortedEntries.get(0));
                    this.leastRecentlyUsedSortedEntries.remove(this.inputSortedEntries.get(0));
                    this.inputSortedEntries.remove(0);
                    break;
                case LAST_IN_FIRST_OUT: {
                    final int index = isAfterAdd ? this.inputSortedEntries.size() - 2 : this.inputSortedEntries.size() - 1;
                    this.entries.remove(this.inputSortedEntries.get(index));
                    this.leastRecentlyUsedSortedEntries.remove(this.inputSortedEntries.get(index));
                    this.inputSortedEntries.remove(index);
                }
                break;
                case LEAST_RECENTLY_USED:
                    this.entries.remove(this.leastRecentlyUsedSortedEntries.get(0));
                    this.inputSortedEntries.remove(this.leastRecentlyUsedSortedEntries.get(0));
                    this.leastRecentlyUsedSortedEntries.remove(0);
                    break;
                default:
                    assert (false);
            }
        }
    }
}
