package academy.pocu.comp2500.lab4;

public class LinkedHashNode<K, V> {
    private final K key;
    private V data;
    private LinkedHashNode<K, V> pre;
    private LinkedHashNode<K, V> next;

    public LinkedHashNode(final K key, final V data) {
        this(key, data, null, null);
    }

    public LinkedHashNode(final K key, final V data, final LinkedHashNode<K, V> pre, final LinkedHashNode<K, V> next) {
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

    public LinkedHashNode<K, V> getNext() {
        return next;
    }

    public void setNext(final LinkedHashNode<K, V> next) {
        this.next = next;
    }

    public LinkedHashNode<K, V> getPre() {
        return pre;
    }

    public void setPre(final LinkedHashNode<K, V> pre) {
        this.pre = pre;
    }
}
