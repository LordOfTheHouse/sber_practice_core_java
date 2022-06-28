package practice.collectionsMap;

import practice.collections.Collection;

public class TreeMap implements Map {

    private Node rootNode;
    private int size;

    public TreeMap() {
        rootNode = null;
        size = 0;
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean containsKey(Object key) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Collection entrySet() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object get(Object key) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Collection keySet() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object put(Object key, Object value) {
        Node newNode = new Node(new Entry(key, value)); // создание нового узла
        if (rootNode == null) { // если корневой узел не существует
            rootNode = newNode;// то новый элемент и есть корневой узел
        } else {
            Node parent;
            Node child = rootNode;
            while (true) {
                parent = child; 
                if (key.equals(((Entry) child.getValue()).getKey())) {
                    child.setValue(newNode);
                    return newNode;
                } else if (key.hashCode() < ((Entry) child.getValue()).getKey().hashCode()) {
                    child = child.getLeft();
                    if (child == null) {
                        parent.setLeft(newNode);
                        size++;
                        return newNode;
                    }
                } else {
                    child = child.getRight();
                    if (child == null) {
                        parent.setRight(newNode);
                        size++;
                        return newNode;
                    }
                }
            }
        }
        return newNode;
    }

    @Override
    public Object remove(Object key) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Collection values() {
        // TODO Auto-generated method stub
        return null;
    }

}
