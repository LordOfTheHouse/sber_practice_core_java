package practice.collections;

import java.util.*;

public class LinkedList implements List, Deque {
    private Node begin;
    private Node end;
    private int size;

    public LinkedList() {
        begin = new Node();
        end = new Node();
        begin.next = end;
        end.prev = begin;
        size = 0;
    }

    @Override
    public void add(int index, Object item) {
        if (index > size || index < 0) {
            throw new NoSuchElementException();
        } else if (index == size) {
            addLast(item);
        } else {
            Node buff = begin.next;
            for (int i = 0; i < index; i++) {
                buff = buff.next;
            }
            Node ad = new Node(buff.prev, item, buff);
            buff.prev.next = ad;
            buff.prev = ad;
            size++;
        }
    }

    @Override
    public Object get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node obj = begin.next;
        int i = 0;
        while (i < index) {
            obj = obj.next;
            i++;
        }
        return obj.item;
    }

    @Override
    public int indexOf(Object item) {
        int i = 0;
        Node buff = begin.next;
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
    public int lastIndexOf(Object item) {
        int i = size - 1;
        Node buff = end.prev;
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
    public Object remove(int index) {
        if (index >= size || index < 0) {
            throw new NoSuchElementException();
        } else {
            Object res = null;
            Node buff = begin.next;
            for (int i = 0; i < index; i++) {
                buff = buff.next;
            }
            res = delElement(buff);
            return res;
        }
    }

    private Object delElement(Node buff) {
        Object res = null;
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
    public void set(int index, Object item) {
        if (index > size || index < 0) {
            throw new NoSuchElementException();
        } else if (index == size) {
            addLast(item);
        } else if (index < (int) size / 2) {
            Node buff = begin.next;
            for (int i = 0; i < index; i++) {
                buff = buff.next;
            }
            buff.item = item;
        } else {
            Node buff = end.prev;
            for (int i = size; i > index + 1; i--) {
                buff = buff.prev;
            }
            buff.item = item;
        }

    }

    @Override
    public List subList(int from, int to) {
        if (to >= size || from > to || from < 0 || to < 0)
            throw new IndexOutOfBoundsException();
        LinkedList newList = new LinkedList();
        Node buff = begin.next;
        for (int i = 0; i < to; i++) {
            if (i >= from) {
                newList.addLast(buff.item);
            }
            buff = buff.next;
        }
        return (List) newList;
    }

    @Override
    public boolean add(Object item) {
        addLast(item);
        return true;
    }

    @Override
    public void clear() {
        Node buff = begin.next;
        while (buff.next != null) {
            delElement(buff);
            buff = buff.next;
        }
    }

    @Override
    public boolean contains(Object item) {
        Node buff = begin.next;
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
    public boolean remove(Object item) {
        boolean isDelete = false;
        Node buff = begin.next;
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
    public void addFirst(Object item) {
        if (begin.next.equals(end)) {
            Node el = new Node(begin, item, end);
            begin.next = el;
            end.prev = el;
        } else {
            Node el = new Node(null, item, begin.next);
            begin.next.prev = el;
            begin.next = el;
        }
        size++;
    }

    @Override
    public void addLast(Object item) {
        if (end.prev.equals(begin)) {
            Node el = new Node(begin, item, end);
            begin.next = el;
            end.prev = el;
        } else {
            Node el = new Node(end.prev, item, null);
            end.prev.next = el;
            end.prev = el;
        }
        size++;
    }

    @Override
    public Object getFirst() throws NoSuchElementException {
        if (size == 0)
            throw new NoSuchElementException();
        return begin.next.item;

    }

    @Override
    public Object getLast() throws NoSuchElementException {
        if (size == 0)
            throw new NoSuchElementException();
        return end.prev.item;
    }

    @Override
    public Object pollFirst() {
        if (size == 0) {
            return null;
        } else {
            Object el = begin.next.item;
            begin.next.next.prev = begin;
            begin.next = begin.next.next;
            size--;
            return el;
        }
    }

    @Override
    public Object pollLast() {
        if (size == 0) {
            return null;
        } else {
            Object el = end.prev.item;
            end.prev.prev.next = end;
            end.prev = end.prev.prev;
            size--;
            return el;
        }
    }

    @Override
    public Object removeFirst() {
        if (size == 0) {
            throw new NoSuchElementException();
        } else {
            Object el = begin.next.item;
            begin.next.next.prev = begin;
            begin.next = begin.next.next;
            size--;
            return el;
        }
    }

    @Override
    public Object removeLast() {
        if (size == 0) {
            throw new NoSuchElementException();
        } else {
            Object el = end.prev.item;
            end.prev.prev.next = end;
            end.prev = end.prev.prev;
            size--;
            return el;
        }
    }
}
