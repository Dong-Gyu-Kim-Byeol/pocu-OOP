package academy.pocu.comp2500.lab4;

public class HashNode<K, V> {
    private K key;
    private V data;
    private HashNode<K, V> pre;
    private HashNode<K, V> next;

    public HashNode(final K key, final V data) {
        this(key, data, null, null);
    }

    public HashNode(final K key, final V data, final HashNode<K, V> pre, final HashNode<K, V> next) {
        this.key = key;
        this.data = data;
        this.pre = pre;
        this.next = next;
    }

    public K getKey() {
        return key;
    }

    public V getData() {
        return data;
    }

    public void setData(final V data) {
        this.data = data;
    }

    public HashNode<K, V> getNext() {
        return next;
    }

    public void setNext(final HashNode<K, V> next) {
        this.next = next;
    }

    public HashNode<K, V> getPre() {
        return pre;
    }

    public void setPre(final HashNode<K, V> pre) {
        this.pre = pre;
    }
}
