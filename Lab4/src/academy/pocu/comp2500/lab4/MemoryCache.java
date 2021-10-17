package academy.pocu.comp2500.lab4;

public class MemoryCache {
    private static int maxInstanceCount;
    private static LinkedHashMap<String, MemoryCache> instances;

    private EvictionPolicy evictionPolicy;
    private int maxEntryCount;
    private final LinkedHashMap<String, String> lruEntries;
    private final LinkedHashMap<String, String> inputEntries;


    // static public
    public static void setMaxInstanceCount(final int maxInstanceCount) {
        assert (maxInstanceCount > 0);
        MemoryCache.maxInstanceCount = maxInstanceCount;
        MemoryCache.instancesCountCheckAndRemove();
    }

    public static MemoryCache getInstance(final String diskName) {
        if (instances == null) {
            MemoryCache.clear();
        }

        if (MemoryCache.instances.containsKey(diskName) == false) {
            final MemoryCache newMemoryCache = new MemoryCache();
            MemoryCache.instances.put(diskName, newMemoryCache);
        } else {
            MemoryCache.updateLruDiskNames(diskName);
        }

        MemoryCache.instancesCountCheckAndRemove();
        return MemoryCache.instances.get(diskName);
    }

    public static void clear() {
        MemoryCache.maxInstanceCount = Integer.MAX_VALUE;

        if (MemoryCache.instances != null) {
            MemoryCache.instances.clear();
        } else {
            MemoryCache.instances = new LinkedHashMap<String, MemoryCache>();
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
        assert (this.lruEntries.size() == this.inputEntries.size());

        this.lruEntries.put(key, value);
        this.inputEntries.put(key, value);
        this.updateLruEntries(key);
        assert (this.lruEntries.size() == this.inputEntries.size());

        this.entriesCountCheckAndRemove(true);
        assert (this.lruEntries.size() == this.inputEntries.size());
    }

    public String getEntryOrNull(final String key) {
        if (this.lruEntries.containsKey(key)) {
            this.updateLruEntries(key);
            return this.lruEntries.get(key);
        } else {
            return null;
        }
    }


    // static private
    private static void updateLruDiskNames(final String diskName) {
        final LinkedHashNode<String, MemoryCache> updateLru = MemoryCache.instances.getNode(diskName);
        assert (updateLru != null);

        MemoryCache.instances.remove(diskName);
        MemoryCache.instances.putNode(diskName, updateLru);
    }

    private static void instancesCountCheckAndRemove() {
        assert (MemoryCache.instances.size() == MemoryCache.instances.size());

        while (MemoryCache.instances.size() > MemoryCache.maxInstanceCount) {
            MemoryCache.instances.remove(MemoryCache.instances.getFrontKey());
        }
    }


    // private
    private MemoryCache() {
        this.evictionPolicy = EvictionPolicy.LEAST_RECENTLY_USED;
        this.maxEntryCount = Integer.MAX_VALUE;
        this.lruEntries = new LinkedHashMap<String, String>();
        this.inputEntries = new LinkedHashMap<String, String>();
    }

    private void updateLruEntries(final String key) {
        final LinkedHashNode<String, String> updateLru = this.lruEntries.getNode(key);
        assert (updateLru != null);

        this.lruEntries.remove(key);
        this.lruEntries.putNode(key, updateLru);
    }

    private void entriesCountCheckAndRemove(final boolean isAfterAdd) {
        assert (this.lruEntries.size() == this.inputEntries.size());

        while (this.inputEntries.size() > this.maxEntryCount) {
            switch (this.evictionPolicy) {
                case FIRST_IN_FIRST_OUT: {
                    this.lruEntries.remove(this.inputEntries.getFrontKey());
                    this.inputEntries.remove(this.inputEntries.getFrontKey());
                }
                break;
                case LAST_IN_FIRST_OUT: {
                    final String removeKey = isAfterAdd ? this.inputEntries.getNear().getPre().getKey() : this.inputEntries.getNearKey();
                    this.lruEntries.remove(removeKey);
                    this.inputEntries.remove(removeKey);
                }
                break;
                case LEAST_RECENTLY_USED: {
                    this.inputEntries.remove(this.lruEntries.getFrontKey());
                    this.lruEntries.remove(this.lruEntries.getFrontKey());
                }
                break;
                default:
                    assert (false);
            }
        }

        assert (this.lruEntries.size() == this.inputEntries.size());
    }
}
