package academy.pocu.comp2500.lab4;

import java.util.HashMap;

public class LinkedHashMap<K, V> {
    private final HashMap<K, HashNode<K, V>> hashMap;
    private HashNode<K, V> front;
    private HashNode<K, V> near;

    public LinkedHashMap() {
        hashMap = new HashMap<K, HashNode<K, V>>();
    }

    public V get(final K key) {
        return hashMap.get(key).getData();
    }

    public HashNode<K, V> getNode(final K key) {
        return hashMap.get(key);
    }

    public void put(final K key, final V value) {
        if (this.hashMap.containsKey(key)) {
            this.hashMap.get(key).setData(value);
        } else if (front == null) {
            this.front = new HashNode<K, V>(key, value);
            this.near = this.front;
            this.hashMap.put(this.front.getKey(), this.front);
        } else {
            final HashNode<K, V> nextNear = new HashNode<K, V>(key, value, this.near, null);
            this.near.setNext(nextNear);
            this.near = nextNear;
            this.hashMap.put(nextNear.getKey(), nextNear);
        }
    }

    public void putNode(final K key, final HashNode<K, V> valueNode) {
        assert (key.equals(valueNode.getKey()));
        if (key.equals(valueNode.getKey()) == false) {
            return;
        }

        valueNode.setPre(null);
        valueNode.setNext(null);

        if (this.hashMap.containsKey(key)) {
            final HashNode<K, V> now = this.hashMap.get(key);
            valueNode.setPre(now.getPre());
            valueNode.setNext(now.getNext());

            now.getPre().setNext(valueNode);
            now.getNext().setPre(valueNode);
        } else if (front == null) {
            this.front = valueNode;
            this.near = this.front;
        } else {
            valueNode.setPre(this.near);

            this.near.setNext(valueNode);
            this.near = valueNode;
        }

        this.hashMap.put(key, valueNode);
    }

    public void remove(final K key) {
        if (this.hashMap.containsKey(key) == false) {
            return;
        }

        if (this.hashMap.size() == 1) {
            assert (this.front == this.near);
            this.front = null;
            this.near = null;
        } else if (this.front.getKey().equals(key)) {
            this.front = this.front.getNext();
            this.front.setPre(null);
        } else if (this.near.getKey().equals(key)) {
            this.near = this.near.getPre();
            this.near.setNext(null);
        } else {
            final HashNode<K, V> removeNode = this.hashMap.get(key);
            final HashNode<K, V> pre = removeNode.getPre();
            final HashNode<K, V> next = removeNode.getNext();
            pre.setNext(next);
            next.setPre(pre);
        }
        this.hashMap.remove(key);
    }

    public boolean containsKey(final K key) {
        return this.hashMap.containsKey(key);
    }

    public K getFrontKey() {
        return front.getKey();
    }

    public K getNearKey() {
        return near.getKey();
    }

    public HashNode<K, V> getFront() {
        return front;
    }

    public HashNode<K, V> getNear() {
        return near;
    }

    public int size() {
        return this.hashMap.size();
    }

    public void clear() {
        this.hashMap.clear();
        this.front = null;
        this.near = null;
    }
}
