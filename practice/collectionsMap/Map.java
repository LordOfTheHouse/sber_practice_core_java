package practice.collectionsMap;

import practice.collections.*;

public interface Map<K, V> {
    int size();

    boolean isEmpty();

    boolean containsKey(K key);

    boolean containsValue(V value);

    V get(K key);

    Entry<K, V> put(K key, V value);

    V remove(K key);

    void clear();

    Collection<V> values();

    Collection<K> keySet();

    Collection<Entry<K, V>> entrySet();
}
