package practice.collections;

import java.util.*;

public class ListIterator implements Iterator<Object> {
    private List arr;
    private int numberElement;

    public ListIterator(List arr) {
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
    public Object next() {
        if (hasNext()) {
            numberElement++;
            return arr.get(numberElement - 1);
        } else {
            throw new NoSuchElementException("Not element in ArrayList");
        }
    }
}
