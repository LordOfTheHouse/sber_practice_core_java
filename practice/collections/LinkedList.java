package practice.collections;

import java.util.*;

public class LinkedList<E> implements List<E>, Deque<E> {

    private Node<E> begin;
    private Node<E> end;
    private int size;

    public LinkedList() {
        begin = new Node<>();
        end = new Node<>();
        begin.next = end;
        end.prev = begin;
        size = 0;
    }

    @Override
    public void add(int index, E item) {
        if (index > size || index < 0) {
            throw new NoSuchElementException();
        } else if (index == size) {
            addLast(item);
        } else if (index == 0) {
            addFirst(item);
        } else {
            Node<E> buff = begin.next;
            for (int i = 0; i < index; i++) {
                buff = buff.next;
            }
            Node<E> ad = new Node<>(buff.prev, item, buff);
            buff.prev.next = ad;
            buff.prev = ad;
            size++;
        }
    }

    @Override
    public E get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> obj = begin.next;
        int i = 0;
        while (i < index) {
            obj = obj.next;
            i++;
        }
        return obj.item;
    }

    @Override
    public int indexOf(E item) {
        int i = 0;
        Node<E> buff = begin.next;
        while (i < size) {
            if (buff.item == item) {
                return i;
            }
            buff = buff.next;
            i++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(E item) {
        int i = size - 1;
        Node<E> buff = end.prev;
        while (i >= 0) {
            if (buff.item == item) {
                return i;
            }
            buff = buff.prev;
            i--;
        }
        return -1;
    }

    @Override
    public E remove(int index) {
        if (index >= size || index < 0) {
            throw new NoSuchElementException();
        } else {
            E res = null;
            Node<E> buff = begin.next;
            for (int i = 0; i < index; i++) {
                buff = buff.next;
            }
            res = delElement(buff);
            return res;
        }
    }

    private E delElement(Node<E> buff) {
        E res = null;
        if (buff.next != null && buff.prev != null) {
            res = buff.item;
            buff.next.prev = buff.prev;
            buff.prev.next = buff.next;
        } else if (buff.next == null) {
            res = buff.item;
            end.prev = buff.prev;
            buff.prev.next = end;
        } else if (buff.prev == null) {
            res = buff.item;
            begin.next = buff.next;
            buff.next.prev = begin;
        }
        size--;
        return res;
    }

    @Override
    public void set(int index, E item) {
        if (index > size || index < 0) {
            throw new NoSuchElementException();
        } else if (index == size) {
            addLast(item);
        } else if (index < (int) size / 2) {
            Node<E> buff = begin.next;
            for (int i = 0; i < index; i++) {
                buff = buff.next;
            }
            buff.item = item;
        } else {
            Node<E> buff = end.prev;
            for (int i = size; i > index + 1; i--) {
                buff = buff.prev;
            }
            buff.item = item;
        }

    }

    @Override
    public List<E> subList(int from, int to) {
        if (to > size || from > to || from < 0 || to < 0)
            throw new IndexOutOfBoundsException();
        LinkedList<E> newList = new LinkedList<>();
        Node<E> buff = begin.next;
        for (int i = 0; i < to; i++) {
            if (i >= from) {
                newList.addLast(buff.item);
            }
            buff = buff.next;
        }
        return newList;
    }

    @Override
    public boolean add(E item) {
        addLast(item);
        return true;
    }

    @Override
    public void clear() {
        Node<E> buff = begin.next;
        while (buff.next != null) {
            delElement(buff);
            buff = buff.next;
        }
    }

    @Override
    public boolean contains(E item) {
        Node<E> buff = begin.next;
        while (buff.item != item) {
            if (buff.next == null) {
                return false;
            }
            buff = buff.next;
        }
        return true;
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
        boolean isDelete = false;
        Node<E> buff = begin.next;
        while (buff != null) {
            if (buff.item == item) {
                delElement(buff);
                isDelete = true;
            }
            buff = buff.next;
        }
        return isDelete;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void addFirst(E item) {
        if (begin.next.equals(end)) {
            Node<E> el = new Node<>(begin, item, end);
            begin.next = el;
            end.prev = el;
        } else {
            Node<E> el = new Node<>(null, item, begin.next);
            begin.next.prev = el;
            begin.next = el;
        }
        size++;
    }

    @Override
    public void addLast(E item) {
        if (end.prev.equals(begin)) {
            Node<E> el = new Node<>(begin, item, end);
            begin.next = el;
            end.prev = el;
        } else {
            Node<E> el = new Node<>(end.prev, item, null);
            end.prev.next = el;
            end.prev = el;
        }
        size++;
    }

    @Override
    public E getFirst() throws NoSuchElementException {
        if (size == 0)
            throw new NoSuchElementException();
        return begin.next.item;

    }

    @Override
    public E getLast() throws NoSuchElementException {
        if (size == 0)
            throw new NoSuchElementException();
        return end.prev.item;
    }

    @Override
    public E pollFirst() {
        if (size == 0) {
            return null;
        } else {
            E el = begin.next.item;
            begin.next.next.prev = begin;
            begin.next = begin.next.next;
            size--;
            return el;
        }
    }

    @Override
    public E pollLast() {
        if (size == 0) {
            return null;
        } else {
            E el = end.prev.item;
            end.prev.prev.next = end;
            end.prev = end.prev.prev;
            size--;
            return el;
        }
    }

    @Override
    public E removeFirst() {
        if (size == 0) {
            throw new NoSuchElementException();
        } else {
            E el = begin.next.item;
            begin.next.next.prev = begin;
            begin.next = begin.next.next;
            size--;
            return el;
        }
    }

    @Override
    public E removeLast() {
        if (size == 0) {
            throw new NoSuchElementException();
        } else {
            E el = end.prev.item;
            end.prev.prev.next = end;
            end.prev = end.prev.prev;
            size--;
            return el;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new ListIterator<>(this);
    }
}
