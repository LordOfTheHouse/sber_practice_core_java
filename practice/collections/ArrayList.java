package practice.collections;

import java.util.Iterator;

public class ArrayList<E> implements List<E> {

    private Object[] obj;
    private int capacity;
    private int size;

    public ArrayList(ArrayList<E> aList) {
        obj = aList.getObj();
        capacity = aList.getCapacity();
        size = aList.size();
    }

    public ArrayList() {
        capacity = 10;
        obj = new Object[capacity];
        size = 0;
    }

    @Override
    public void add(int index, E item) {
        if (size == capacity) {
            obj = copyList();
        }
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        } else if (index == size) {
            obj[index] = item;
            size++;
        } else {
            for (int i = size; i > index; i--) {
                obj[i] = obj[i - 1];
            }
            obj[index] = item;
            size++;
        }
    }

    @Override
    public E get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            return (E) obj[index];
        }
    }

    @Override
    public int indexOf(E item) {
        for (int i = 0; i < size; i++) {
            if (obj[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(E item) {
        for (int i = size - 1; i >= 0; --i) {
            if (obj[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public E remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            E el = (E) obj[index];
            for (int i = index; i < size; i++) {
                obj[i] = obj[i + 1];
            }
            size--;
            return el;
        }
    }

    @Override
    public void set(int index, E item) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        } else if (index == size) {
            add(item);
        } else {
            obj[index] = item;
        }
    }

    @Override
    public List<E> subList(int from, int to) {
        if (to > size || from < 0 || to < from || to < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            ArrayList<E> subObj = new ArrayList<>();
            for (int i = from; i < to; i++) {
                subObj.add((E) obj[i]);
            }
            return subObj;
        }
    }

    @Override
    public boolean add(E item) {
        if (size < capacity) {
            obj[size] = item;
        } else {
            Object[] obj2 = copyList();
            obj2[size] = item;
            obj = obj2;
        }
        size++;
        return true;
    }

    private Object[] copyList() {
        capacity = (capacity * 3) / 2 + 1;
        Object[] obj2 = new Object[capacity];
        for (int i = 0; i < size; i++) {
            obj2[i] = obj[i];
        }
        return obj2;
    }

    @Override
    public void clear() {
        capacity = 10;
        obj = new Object[capacity];
        size = 0;
    }

    @Override
    public boolean contains(E item) {
        for (Object el : obj) {
            if (item.equals(el)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(E item) {
        if (size == 0) {
            return false;
        }
        int sizeCopy = size;
        for (int i = 0; i < size; i++) {
            if (obj[i].equals(item)) {
                remove(i);
                remove(item);
                break;
            }
        }
        return !(sizeCopy == size);
    }

    @Override
    public int size() {
        return size;
    }

    private Object[] getObj() {
        return obj;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public Iterator<E> iterator() {
        return new ListIterator<>(this);
    }

}
