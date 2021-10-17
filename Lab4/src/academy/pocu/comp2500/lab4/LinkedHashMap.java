package academy.pocu.comp2500.lab4;

import java.util.HashMap;

public class LinkedHashMap<K, V> {
    private final HashMap<K, LinkedHashNode<K, V>> hashMap;
    private LinkedHashNode<K, V> front;
    private LinkedHashNode<K, V> near;

    public LinkedHashMap() {
        hashMap = new HashMap<K, LinkedHashNode<K, V>>();
    }

    public V get(final K key) {
        return hashMap.get(key).getData();
    }

    public LinkedHashNode<K, V> getNode(final K key) {
        return hashMap.get(key);
    }

    public void put(final K key, final V value) {
        if (this.hashMap.containsKey(key)) {
            this.hashMap.get(key).setData(value);
        } else if (front == null) {
            this.front = new LinkedHashNode<K, V>(key, value);
            this.near = this.front;
            this.hashMap.put(this.front.getKey(), this.front);
        } else {
            final LinkedHashNode<K, V> nextNear = new LinkedHashNode<K, V>(key, value, this.near, null);
            this.near.setNext(nextNear);
            this.near = nextNear;
            this.hashMap.put(nextNear.getKey(), nextNear);
        }
    }

    public void putNode(final K key, final LinkedHashNode<K, V> valueNode) {
        assert (key.equals(valueNode.getKey()));
        if (key.equals(valueNode.getKey()) == false) {
            return;
        }

        valueNode.setPre(null);
        valueNode.setNext(null);

        if (this.hashMap.containsKey(key)) {
            final LinkedHashNode<K, V> now = this.hashMap.get(key);
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
            final LinkedHashNode<K, V> removeNode = this.hashMap.get(key);
            final LinkedHashNode<K, V> pre = removeNode.getPre();
            final LinkedHashNode<K, V> next = removeNode.getNext();
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

    public LinkedHashNode<K, V> getFront() {
        return front;
    }

    public LinkedHashNode<K, V> getNear() {
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
