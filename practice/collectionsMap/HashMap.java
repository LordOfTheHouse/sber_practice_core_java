package practice.collectionsMap;

import practice.collections.*;

public class HashMap<K, V> implements Map<K, V> {

    private LinkedList<Entry<K, V>>[] buckets;
    private int capacity;
    private int size;

    public HashMap() {
        capacity = (int) Math.pow(2, 20);
        size = 0;
        buckets = new LinkedList[capacity];
    }

    @Override
    public void clear() {
        size = 0;
        buckets = new LinkedList[capacity];
    }

    @Override
    public boolean containsKey(K key) {
        for (LinkedList<Entry<K, V>> li : buckets) {
            if (li != null) {
                for (int i = 0; i < li.size(); i++) {
                    if (((Entry<K, V>) li.get(i)).getKey().equals(key)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for (LinkedList<Entry<K, V>> li : buckets) {
            if (li != null) {
                for (int i = 0; i < li.size(); i++) {
                    V buff = ((Entry<K, V>) li.get(i)).getValue();
                    if (buff == null && value == null) {
                        return true;
                    } else if (buff == null) {
                        continue;
                    } else if (buff.equals(value)) {
                        return true;
                    }

                }
            }
        }
        return false;
    }

    @Override
    public Collection<Entry<K, V>> entrySet() {
        ArrayList<Entry<K, V>> entry = new ArrayList<>();
        for (LinkedList<Entry<K, V>> li : buckets) {
            if (li != null) {
                for (int i = 0; i < li.size(); i++) {
                    entry.add(li.get(i));
                }
            }
        }
        return entry;
    }

    @Override
    public V get(K key) {
        int bucketNumber = Math.abs(key.hashCode() % buckets.length);
        LinkedList<Entry<K, V>> list = buckets[bucketNumber];
        for (int i = 0; i < list.size(); i++) {
            if (((Entry<K, V>) list.get(i)).getKey().equals(key)) {
                return ((Entry<K, V>) list.get(i)).getValue();
            }
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Collection<K> keySet() {
        ArrayList<K> keys = new ArrayList<>();
        for (LinkedList<Entry<K, V>> li : buckets) {
            if (li != null) {
                for (int i = 0; i < li.size(); i++) {
                    keys.add(((Entry<K, V>) li.get(i)).getKey());
                }
            }
        }
        return keys;
    }

    @Override
    public Entry<K, V> put(K key, V value) {
        int bucketNumber =  Math.abs(key.hashCode() % buckets.length);
        var list = buckets[bucketNumber];
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                if (((Entry<K, V>) list.get(i)).getKey().equals(key)) {
                    ((Entry<K, V>) list.get(i)).setValue(value);
                    return new Entry<>(key, value);
                }
            }
        } else {
            list = new LinkedList<Entry<K, V>>();
        }
        list.addLast(new Entry<>(key, value));
        buckets[bucketNumber] = list;
        size++;
        return new Entry<>(key, value);
    }

    @Override
    public V remove(K key) {
        for (LinkedList<Entry<K, V>> li : buckets) {
            if (li != null) {
                for (int i = 0; i < li.size(); i++) {
                    if (((Entry<K, V>) li.get(i)).getKey().equals(key)) {
                        size--;
                        return ((Entry<K, V>) li.remove(i)).getValue();
                    }
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Collection<V> values() {
        ArrayList<V> vals = new ArrayList<>();
        for (LinkedList<Entry<K, V>> li : buckets) {
            if (li != null) {
                for (int i = 0; i < li.size(); i++) {
                    vals.add(((Entry<K, V>) li.get(i)).getValue());
                }
            }
        }
        return vals;
    }

}
