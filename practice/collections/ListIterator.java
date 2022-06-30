package practice.collections;

import java.util.*;

public class ListIterator<E> implements Iterator<E> {
    private List<E> arr;
    private int numberElement;

    public ListIterator(List<E> arr) {
        this.arr = arr;
        this.numberElement = 0;
    }

    @Override
    public boolean hasNext() {
        if (numberElement + 1 <= arr.size()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public E next() {
        if (hasNext()) {
            numberElement++;
            return arr.get(numberElement - 1);
        } else {
            throw new NoSuchElementException("Not element in ArrayList");
        }
    }
}
