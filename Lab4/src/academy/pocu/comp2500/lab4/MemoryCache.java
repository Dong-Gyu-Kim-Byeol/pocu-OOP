package academy.pocu.comp2500.lab4;

import java.util.ArrayList;
import java.util.HashMap;

public class MemoryCache {
    private static int maxInstanceCount;
    private static HashMap<String, MemoryCache> instances;
    private static ArrayList<String> lruDiskNames;

    private EvictionPolicy evictionPolicy;
    private int maxEntryCount;
    private final HashMap<String, String> entries;
    private final ArrayList<String> inputSortedEntries;
    private final ArrayList<String> lruEntries;


    // static public
    public static void setMaxInstanceCount(final int maxInstanceCount) {
        assert (maxInstanceCount > 0);
        MemoryCache.maxInstanceCount = maxInstanceCount;
        MemoryCache.instancesCountCheckAndRemove();
    }

    public static MemoryCache getInstance(final String diskName) {
        if (instances == null) {
            assert (MemoryCache.lruDiskNames == null);

            MemoryCache.maxInstanceCount = 30;
            MemoryCache.instances = new HashMap<String, MemoryCache>(MemoryCache.maxInstanceCount);
            MemoryCache.lruDiskNames = new ArrayList<String>(MemoryCache.maxInstanceCount);
        }

        assert (MemoryCache.lruDiskNames.size() == MemoryCache.instances.size());

        if (MemoryCache.instances.containsKey(diskName) == false) {
            final MemoryCache newMemoryCache = new MemoryCache();
            MemoryCache.instances.put(diskName, newMemoryCache);
        }
        MemoryCache.updateLruDiskNames(diskName);

        MemoryCache.instancesCountCheckAndRemove();
        return MemoryCache.instances.get(diskName);
    }

    public static void clear() {
        if (MemoryCache.instances != null) {
            MemoryCache.instances.clear();
        }

        if (MemoryCache.lruDiskNames != null) {
            MemoryCache.lruDiskNames.clear();
        }
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
        assert (this.inputSortedEntries.size() == this.lruEntries.size());
        assert (this.inputSortedEntries.size() == this.entries.size());

        if (this.entries.containsKey(key) == false) {
            this.inputSortedEntries.add(key);
        }
        this.entries.put(key, value);
        this.updateLruEntries(key);

        this.entriesCountCheckAndRemove(true);

        assert (this.inputSortedEntries.size() == this.lruEntries.size());
        assert (this.inputSortedEntries.size() == this.entries.size());
    }

    public String getEntryOrNull(final String key) {
        if (this.entries.containsKey(key)) {
            this.updateLruEntries(key);
            return this.entries.get(key);
        } else {
            return null;
        }
    }


    // static private
    private static void updateLruDiskNames(final String diskName) {
        MemoryCache.lruDiskNames.remove(diskName);
        MemoryCache.lruDiskNames.add(diskName);
    }

    private static void instancesCountCheckAndRemove() {
        assert (MemoryCache.lruDiskNames.size() == MemoryCache.instances.size());

        while (MemoryCache.instances.size() > MemoryCache.maxInstanceCount) {
            MemoryCache.instances.remove(MemoryCache.lruDiskNames.get(0));
            MemoryCache.lruDiskNames.remove(0);
        }
    }


    // private
    private MemoryCache() {
        this.evictionPolicy = EvictionPolicy.LEAST_RECENTLY_USED;
        this.maxEntryCount = 30;
        this.entries = new HashMap<String, String>(this.maxEntryCount);
        this.inputSortedEntries = new ArrayList<String>(this.maxEntryCount);
        this.lruEntries = new ArrayList<String>(this.maxEntryCount);
    }

    private void updateLruEntries(final String key) {
        this.lruEntries.remove(key);
        this.lruEntries.add(key);
    }

    private void entriesCountCheckAndRemove(final boolean isAfterAdd) {
        assert (this.inputSortedEntries.size() == this.lruEntries.size());
        assert (this.inputSortedEntries.size() == this.entries.size());

        while (this.entries.size() > this.maxEntryCount) {
            switch (this.evictionPolicy) {
                case FIRST_IN_FIRST_OUT: {
                    this.entries.remove(this.inputSortedEntries.get(0));
                    this.lruEntries.remove(this.inputSortedEntries.get(0));
                    this.inputSortedEntries.remove(0);
                }
                break;
                case LAST_IN_FIRST_OUT: {
                    final int index = isAfterAdd ? this.inputSortedEntries.size() - 2 : this.inputSortedEntries.size() - 1;
                    this.entries.remove(this.inputSortedEntries.get(index));
                    this.lruEntries.remove(this.inputSortedEntries.get(index));
                    this.inputSortedEntries.remove(index);
                }
                break;
                case LEAST_RECENTLY_USED: {
                    this.entries.remove(this.lruEntries.get(0));
                    this.inputSortedEntries.remove(this.lruEntries.get(0));
                    this.lruEntries.remove(0);
                }
                break;
                default:
                    assert (false);
            }
        }
    }
}
