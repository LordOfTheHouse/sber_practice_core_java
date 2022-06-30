package practice.collectionsMap;

import practice.collections.ArrayList;
import practice.collections.Collection;

public class TreeMap<K, V> implements Map<K, V> {

    private Node<Entry<K, V>> rootNode;
    private int size;
    private boolean flagSearchValue = false;

    public TreeMap() {
        rootNode = null;
        size = 0;
    }

    /* Очищает дерево от элементов */
    @Override
    public void clear() {
        rootNode = null;
        size = 0;
    }

    /* Поиск ключа */
    @Override
    public boolean containsKey(K key) {
        flagSearchValue = false;
        return searchKey(rootNode, key);
    }

    private boolean searchKey(Node<Entry<K, V>> child, K key) {
        if (key.equals(getKeyEntry(child))) {
            flagSearchValue = true;
        }
        if (child.getLeft() != null && !flagSearchValue) {
            searchKey(child.getLeft(), key);
        }
        if (child.getRight() != null && !flagSearchValue) {
            searchKey(child.getRight(), key);
        }
        return flagSearchValue;
    }

    /* Поиск значения */
    @Override
    public boolean containsValue(V value) {
        flagSearchValue = false;
        return searchValue(rootNode, value);
    }

    private boolean searchValue(Node<Entry<K, V>> child, V value) {
        try{
            if (getValueEntry(child).equals(value)) {
                flagSearchValue = true;
            }
        }catch(NullPointerException ex){
            if(value == null){
                flagSearchValue = true;
            }
        }
        if (child.getLeft() != null && !flagSearchValue) {
            searchValue(child.getLeft(), value);
        }
        if (child.getRight() != null && !flagSearchValue) {
            searchValue(child.getRight(), value);
        }
        return flagSearchValue;
    }

    /* Возвращает список со всеми всеми парами ключ-значение хранящимися в дереве */
    @Override
    public Collection<Entry<K, V>> entrySet() {
        ArrayList<Entry<K, V>> li = new ArrayList<>();
        addEntry(rootNode, li);
        return li;
    }

    private void addEntry(Node<Entry<K, V>> child, ArrayList<Entry<K, V>> li) {
        System.out.println(child);
        li.add(child.getValue());
        if (child.getLeft() != null) {
            addEntry(child.getLeft(), li);
        }
        if (child.getRight() != null) {
            addEntry(child.getRight(), li);
        }
    }

    /*
     * Поиск элемента по ключу в дереве
     * спускаемся вниз по дереву пока не найдем нужный элемент
     */
    @Override
    public V get(K key) {
        Node<Entry<K, V>> child = rootNode;
        while (true) {
            if (key.equals(getKeyEntry(child))) {
                return getValueEntry(child);
            } else if (key.hashCode() < getKeyEntry(child).hashCode()) {
                child = child.getLeft();
                if (child == null) {
                    return null;
                }
            } else {
                child = child.getRight();
                if (child == null) {
                    return null;
                }
            }
        }
    }

    /* Проверяет является ли дерево пустым */
    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    /* Возвращает ключи хранящиеся в дереве */
    @Override
    public Collection<K> keySet() {
        ArrayList<K> li = new ArrayList<>();
        addKey(rootNode, li);
        return li;

    }

    private void addKey(Node<Entry<K, V>> child, ArrayList<K> li) {
        li.add(getKeyEntry(child));
        if (child.getLeft() != null) {
            addKey(child.getLeft(), li);
        }
        if (child.getRight() != null) {
            addKey(child.getRight(), li);
        }
    }

    /*
     * Вставляет в дерево пары ключ-значени
     * 1 элемент является корневым, дальнешие вставляются по hash-коду.
     * Элементы с меньшим hash-кодом вставляются влево, с большим вправо.
     */
    @Override
    public Entry<K, V> put(K key, V value) {
        Node<Entry<K, V>> newNode = new Node<>(new Entry<>(key, value));
        if (rootNode == null) {
            size++;
            rootNode = newNode;
        } else {
            Node<Entry<K, V>> parent;
            Node<Entry<K, V>> child = rootNode;
            while (true) {
                parent = child;
                if (getKeyEntry(child).equals(key)) {
                    child.setValue(new Entry<>(key, value));
                    return newNode.getValue();
                } else if (key.hashCode() < getKeyEntry(child).hashCode()) {
                    child = child.getLeft();
                    if (child == null) {
                        parent.setLeft(newNode);
                        size++;
                        return newNode.getValue();
                    }
                } else {
                    child = child.getRight();
                    if (child == null) {
                        parent.setRight(newNode);
                        size++;
                        return newNode.getValue();
                    }
                }
            }
        }
        return newNode.getValue();
    }

    /*
     * Удаление узла по ключу
     * Если узел листовой (нет потомков), то просто удаляем узел
     * Если узел имеет только одного потомка, то вместо нашего узла стваим его
     * потомка
     * Если у угла два потомка:
     * Переходим к правому потомку удаляемого узла, после чего спускаемся вниз по
     * левым
     * потомкам пока не дойдем до последнего. Заменяем удаляем узел на найденный
     * элемент.
     */
    @Override
    public V remove(K key) {

        Node<Entry<K, V>> currentNode = rootNode;
        Node<Entry<K, V>> parentNode = rootNode;

        boolean isLeft = true;

        while (!getKeyEntry(currentNode).equals(key)) {
            parentNode = currentNode;
            if (key.hashCode() < getKeyEntry(currentNode).hashCode()) {
                isLeft = true;
                currentNode = currentNode.getLeft();
            } else {
                isLeft = false;
                currentNode = currentNode.getRight();
            }
            if (currentNode == null) {
                return null;
            }
        }

        if (currentNode.getLeft() == null && currentNode.getRight() == null) {
            if (currentNode == rootNode) {
                rootNode = null;
            } else if (isLeft) {
                parentNode.setLeft(null);
            } else {
                parentNode.setRight(null);
            }
        }

        else if (currentNode.getRight() == null) {
            if (currentNode == rootNode) {
                rootNode = currentNode.getLeft();
            } else if (isLeft) {
                parentNode.setLeft(currentNode.getLeft());
            } else {
                parentNode.setRight(currentNode.getLeft());
            }
        }

        else if (currentNode.getLeft() == null) {
            if (currentNode == rootNode) {
                rootNode = currentNode.getRight();
            } else if (isLeft) {
                parentNode.setLeft(currentNode.getRight());
            } else {
                parentNode.setRight(currentNode.getRight());
            }
        }

        else {
            Node<Entry<K, V>> heir = receiveHeir(currentNode);
            if (currentNode == rootNode) {
                rootNode = heir;
            } else if (isLeft) {
                parentNode.setLeft(heir);
            } else {
                parentNode.setRight(heir);
            }
        }
        size--;
        return getValueEntry(currentNode);
    }

    /* Функция возвращает ключ из Entry */
    private K getKeyEntry(Node<Entry<K, V>> node) {
        return ((Entry<K, V>) node.getValue()).getKey();
    }

    /* Функция возвращает значение из Entry */
    private V getValueEntry(Node<Entry<K, V>> node) {
        return ((Entry<K, V>) node.getValue()).getValue();
    }

    /* Функция возвращеает узел для замены */
    private Node<Entry<K, V>> receiveHeir(Node<Entry<K, V>> node) {
        Node<Entry<K, V>> parentNode = node;
        Node<Entry<K, V>> heirNode = node;
        Node<Entry<K, V>> currentNode = node.getRight();
        while (currentNode != null) {
            parentNode = heirNode;
            heirNode = currentNode;
            currentNode = currentNode.getLeft();
        }
        if (heirNode != node.getRight()) {
            parentNode.setLeft(heirNode.getRight());
            heirNode.setRight(node.getRight());
            heirNode.setLeft(node.getLeft());
        }else{
            heirNode.setLeft(node.getLeft());
        }
        return heirNode;
    }

    /* Возвращает размер дерева */
    @Override
    public int size() {
        return size;
    }

    /* Возвращает все значения хранящиеся в дереве */
    @Override
    public Collection<V> values() {
        ArrayList<V> li = new ArrayList<>();
        addValue(rootNode, li);
        return li;
    }

    private void addValue(Node<Entry<K, V>> child, ArrayList<V> li) {
        li.add(getValueEntry(child));
        if (child.getLeft() != null) {
            addValue(child.getLeft(), li);
        }
        if (child.getRight() != null) {
            addValue(child.getRight(), li);
        }
    }

}
