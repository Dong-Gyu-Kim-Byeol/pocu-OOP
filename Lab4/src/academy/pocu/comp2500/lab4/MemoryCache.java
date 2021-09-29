package academy.pocu.comp2500.lab4;

import java.util.ArrayList;
import java.util.HashMap;

public class MemoryCache {
    private static int maxInstanceCount;
    private static EvictionPolicy evictionPolicy = EvictionPolicy.LEAST_RECENTLY_USED;

    private static HashMap<String, MemoryCache> instances;
    private static ArrayList<String> inputSortedDiskNames;
    private static ArrayList<String> leastRecentlyUsedSortedDiskNames;

    private final String diskName;
    private int maxEntryCount;
    private final HashMap<String, String> entries;
    private final ArrayList<String> inputSortedEntries;
    private final ArrayList<String> leastRecentlyUsedSortedEntries;


    // static public
    public static void setMaxInstanceCount(final int maxInstanceCount) {
        assert (maxInstanceCount > 0);

        MemoryCache.maxInstanceCount = maxInstanceCount;
        MemoryCache.instancesCountCheckAndRemove(false);
    }

    public static void setEvictionPolicy(final EvictionPolicy evictionPolicy) {
        MemoryCache.evictionPolicy = evictionPolicy;
    }

    public static MemoryCache getInstance(final String diskName) {
        if (instances == null) {
            MemoryCache.maxInstanceCount = 3;
            MemoryCache.evictionPolicy = EvictionPolicy.LEAST_RECENTLY_USED;

            MemoryCache.instances = new HashMap<String, MemoryCache>(MemoryCache.maxInstanceCount);
            MemoryCache.inputSortedDiskNames = new ArrayList<String>(MemoryCache.maxInstanceCount);
            MemoryCache.leastRecentlyUsedSortedDiskNames = new ArrayList<String>(MemoryCache.maxInstanceCount);
        }

        if (MemoryCache.instances.containsKey(diskName)) {
            MemoryCache.updateLeastRecentlyUsedSortedDiskNames(diskName);
            return MemoryCache.instances.get(diskName);
        }

        MemoryCache newMemoryCache = new MemoryCache(diskName);
        MemoryCache.instances.put(diskName, newMemoryCache);
        MemoryCache.inputSortedDiskNames.add(diskName);
        MemoryCache.leastRecentlyUsedSortedDiskNames.add(diskName);

        MemoryCache.instancesCountCheckAndRemove(true);

        return newMemoryCache;
    }

    public static void clear() {
        MemoryCache.instances.clear();
        MemoryCache.inputSortedDiskNames.clear();
        MemoryCache.leastRecentlyUsedSortedDiskNames.clear();
    }


    // public
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

        MemoryCache.updateLeastRecentlyUsedSortedDiskNames(this.diskName);
    }

    public String getEntryOrNull(final String key) {
        if (this.entries.containsKey(key)) {
            MemoryCache.updateLeastRecentlyUsedSortedDiskNames(this.diskName);
            this.updateLeastRecentlyUsedSortedEntries(key);
            return this.entries.get(key);
        } else {
            return null;
        }
    }


    // static private
    private static void updateLeastRecentlyUsedSortedDiskNames(final String diskName) {
        assert (MemoryCache.leastRecentlyUsedSortedDiskNames.contains(diskName));

        MemoryCache.leastRecentlyUsedSortedDiskNames.remove(diskName);
        MemoryCache.leastRecentlyUsedSortedDiskNames.add(diskName);
    }

    private static void instancesCountCheckAndRemove(final boolean isAfterAdd) {
        assert (MemoryCache.inputSortedDiskNames.size() == MemoryCache.leastRecentlyUsedSortedDiskNames.size());
        assert (MemoryCache.inputSortedDiskNames.size() == MemoryCache.instances.size());

        while (MemoryCache.instances.size() > MemoryCache.maxInstanceCount) {
            switch (MemoryCache.evictionPolicy) {
                case FIRST_IN_FIRST_OUT:
                    MemoryCache.instances.remove(MemoryCache.inputSortedDiskNames.get(0));
                    MemoryCache.leastRecentlyUsedSortedDiskNames.remove(MemoryCache.inputSortedDiskNames.get(0));
                    MemoryCache.inputSortedDiskNames.remove(0);
                    break;
                case LAST_IN_FIRST_OUT: {
                    final int index = isAfterAdd ? MemoryCache.inputSortedDiskNames.size() - 2 : MemoryCache.inputSortedDiskNames.size() - 1;
                    MemoryCache.instances.remove(MemoryCache.inputSortedDiskNames.get(index));
                    MemoryCache.leastRecentlyUsedSortedDiskNames.remove(MemoryCache.inputSortedDiskNames.get(index));
                    MemoryCache.inputSortedDiskNames.remove(index);
                }
                break;
                case LEAST_RECENTLY_USED:
                    MemoryCache.instances.remove(MemoryCache.leastRecentlyUsedSortedDiskNames.get(0));
                    MemoryCache.inputSortedDiskNames.remove(MemoryCache.leastRecentlyUsedSortedDiskNames.get(0));
                    MemoryCache.leastRecentlyUsedSortedDiskNames.remove(0);
                    break;
                default:
                    assert (false);
            }
        }
    }


    // private
    private MemoryCache(final String diskName) {
        this.diskName = diskName;
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
            switch (MemoryCache.evictionPolicy) {
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
