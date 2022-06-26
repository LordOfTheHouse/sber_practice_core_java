package practice.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class TestLinkedList {
    public static void main(String[] args) {
        testGet();
        testIndexOf();
        testLastIndexOf();
        testRemove();
        testSet();
        testSubList();
        testContains();
        testIsEmpty();
        testSize();
        testGetFirst();
        testGetLast();
        testPollFirst();
        testPollLast();
        testRemoveFirst();
        testRemoveLast();
        testIterator();
    }

    private static void testGet() {
        System.out.println("TEST: GET");
        LinkedList testArr = new LinkedList();
        for (int i = 0; i < 5; i++) {
            testArr.add(i);
        }
        if (testArr.get(0).equals(0))
            System.out.println(true);
        else
            System.out.println(false);
        if (testArr.get(2).equals(2))
            System.out.println(true);
        else
            System.out.println(false);
        if (testArr.get(4).equals(4))
            System.out.println(true);
        else
            System.out.println(false);
        try {
            testArr.get(6);
            testArr.get(-1);
        } catch (IndexOutOfBoundsException ex) {
            System.out.println(true);
        }
    }

    private static void testIndexOf() {
        System.out.println("TEST: INDEX OF");
        LinkedList testArr = new LinkedList();
        for (int i = 0; i < 5; i++) {
            testArr.add(i);
        }
        if (testArr.indexOf(0) == 0)
            System.out.println(true);
        else
            System.out.println(false);
        if (testArr.indexOf(2) == 2)
            System.out.println(true);
        else
            System.out.println(false);
        if (!(testArr.indexOf(4) == 5))
            System.out.println(true);
        else
            System.out.println(false);
    }

    private static void testLastIndexOf() {
        System.out.println("TEST: LAST INDEX OF");
        LinkedList testArr = new LinkedList();
        for (int i = 0; i < 5; i++) {
            testArr.add(i);
        }
        if (testArr.lastIndexOf(0) == 0)
            System.out.println(true);
        else
            System.out.println(false);
        if (testArr.lastIndexOf(2) == 2)
            System.out.println(true);
        else
            System.out.println(false);
        if (!(testArr.lastIndexOf(4) == 5))
            System.out.println(true);
        else
            System.out.println(false);
    }

    private static void testRemove() {
        System.out.println("TEST: REMOVE");
        LinkedList testArr = new LinkedList();
        for (int i = 0; i < 5; i++) {
            testArr.add(i);
        }
        if (testArr.remove(0).equals(0))
            System.out.println(true);
        else
            System.out.println(false);
        if (testArr.remove(0).equals(1))
            System.out.println(true);
        else
            System.out.println(false);
        if (testArr.remove(0).equals(2))
            System.out.println(true);
        else
            System.out.println(false);
        if (testArr.remove(0).equals(3))
            System.out.println(true);
        else
            System.out.println(false);
        if (testArr.remove(0).equals(4))
            System.out.println(true);
        else
            System.out.println(false);
        try {
            testArr.remove(5);
        } catch (NoSuchElementException ex) {
            System.out.println(true);
        }
    }

    private static void testSet() {
        System.out.println("TEST: SET");
        LinkedList testArr = new LinkedList();
        for (int i = 0; i < 5; i++) {
            testArr.add(i);
        }
        for (int i = 4, k = 0; i >= 0; i--, k++) {
            testArr.set(i, k);
        }
        if (testArr.get(0).equals(4))
            System.out.println(true);
        else
            System.out.println(false);
        if (testArr.get(1).equals(3))
            System.out.println(true);
        else
            System.out.println(false);
        if (testArr.get(2).equals(2))
            System.out.println(true);
        else
            System.out.println(false);
        try {
            testArr.set(6, 6);
            testArr.set(-1, 6);
        } catch (NoSuchElementException ex) {
            System.out.println(true);
        }
        testArr.set(5, 6);
        if (testArr.get(5).equals(6))
            System.out.println(true);
        else
            System.out.println(false);
    }

    private static void testSubList() {
        System.out.println("TEST: SUB LIST");
        LinkedList testArr = new LinkedList();
        for (int i = 0; i < 5; i++) {
            testArr.add(i);
        }
        LinkedList testSubList1 = (LinkedList) testArr.subList(1, 2);
        LinkedList testSubList2 = (LinkedList) testArr.subList(2, 4);
        LinkedList testSubList3 = (LinkedList) testArr.subList(0, 4);
        if (testSubList1.get(0).equals(1))
            System.out.println(true);
        else
            System.out.println(false);
        if (testSubList2.get(1).equals(3))
            System.out.println(true);
        else
            System.out.println(false);
        if (testSubList3.get(3).equals(3))
            System.out.println(true);
        else
            System.out.println(false);
        try {
            testArr.subList(5, 10);
        } catch (IndexOutOfBoundsException ex) {
            System.out.println(true);
        }
    }

    private static void testContains() {
        System.out.println("TEST: CONTAINS");
        LinkedList testArr = new LinkedList();
        for (int i = 0; i < 5; i++) {
            testArr.add(i);
        }
        if (testArr.contains(0))
            System.out.println(true);
        else
            System.out.println(false);
        if (testArr.contains(2))
            System.out.println(true);
        else
            System.out.println(false);
        if (testArr.contains(4))
            System.out.println(true);
        else
            System.out.println(false);
        if (!testArr.contains(7))
            System.out.println(true);
        else
            System.out.println(false);
        if (!testArr.contains(-4))
            System.out.println(true);
        else
            System.out.println(false);
    }

    private static void testIsEmpty() {
        System.out.println("TEST: IS EMPTY");
        LinkedList testArr = new LinkedList();
        if (testArr.isEmpty())
            System.out.println(true);
        else
            System.out.println(false);
        for (int i = 0; i < 5; i++) {
            testArr.add(i);
        }
        if (!testArr.isEmpty())
            System.out.println(true);
        else
            System.out.println(false);
        testArr.clear();
        if (testArr.isEmpty())
            System.out.println(true);
        else
            System.out.println(false);
    }

    private static void testSize() {
        System.out.println("TEST: Size");
        LinkedList testArr = new LinkedList();
        for (int i = 0; i < 5; i++) {
            testArr.add(i);
        }
        if (testArr.size() == 5)
            System.out.println(true);
        else
            System.out.println(false);
        testArr.clear();
        if (testArr.size() == 0)
            System.out.println(true);
        else
            System.out.println(false);
        for (int i = 0; i < 1000; i++) {
            testArr.add(i);
        }
        if (testArr.size() == 1000)
            System.out.println(true);
        else
            System.out.println(false);
    }

    private static void testGetFirst() {
        System.out.println("TEST: GET FIRST");
        LinkedList testArr = new LinkedList();
        testArr.addFirst(1);
        if (testArr.getFirst() == (Object) 1)
            System.out.println(true);
        else
            System.out.println(false);
        testArr.addFirst(2);
        if (testArr.getFirst() == (Object) 2)
            System.out.println(true);
        else
            System.out.println(false);
        testArr.addFirst(3);
        if (testArr.getFirst() == (Object) 3)
            System.out.println(true);
        else
            System.out.println(false);
        testArr.clear();
        try {
            testArr.getFirst();
        } catch (NoSuchElementException ex) {
            System.out.println(true);
        }
    }

    private static void testGetLast() {
        System.out.println("TEST: GET LAST");
        LinkedList testArr = new LinkedList();
        testArr.addLast(1);
        if (testArr.getLast() == (Object) 1)
            System.out.println(true);
        else
            System.out.println(false);
        testArr.addLast(2);
        if (testArr.getLast() == (Object) 2)
            System.out.println(true);
        else
            System.out.println(false);
        testArr.addLast(3);
        if (testArr.getLast() == (Object) 3)
            System.out.println(true);
        else
            System.out.println(false);
        testArr.clear();
        try {
            testArr.getLast();
        } catch (NoSuchElementException ex) {
            System.out.println(true);
        }
    }

    private static void testPollFirst() {
        System.out.println("TEST: POLL FIRST");
        LinkedList testArr = new LinkedList();
        testArr.addFirst(1);
        if (testArr.pollFirst() == (Object) 1)
            System.out.println(true);
        else
            System.out.println(false);
        testArr.addFirst(2);
        if (testArr.pollFirst() == (Object) 2)
            System.out.println(true);
        else
            System.out.println(false);
        testArr.addFirst(3);
        if (testArr.pollFirst() == (Object) 3)
            System.out.println(true);
        else
            System.out.println(false);
        testArr.clear();
        if (testArr.pollFirst() == null)
            System.out.println(true);
        else
            System.out.println(false);
    }

    private static void testPollLast() {
        System.out.println("TEST: POLL LAST");
        LinkedList testArr = new LinkedList();
        testArr.addLast(1);
        if (testArr.pollLast() == (Object) 1)
            System.out.println(true);
        else
            System.out.println(false);
        testArr.addLast(2);
        if (testArr.pollLast() == (Object) 2)
            System.out.println(true);
        else
            System.out.println(false);
        testArr.addLast(3);
        if (testArr.pollLast() == (Object) 3)
            System.out.println(true);
        else
            System.out.println(false);
        testArr.clear();
        if (testArr.pollLast() == null)
            System.out.println(true);
        else
            System.out.println(false);
    }

    private static void testRemoveFirst() {
        System.out.println("TEST: REMOVE FIRST");
        LinkedList testArr = new LinkedList();
        testArr.addFirst(1);
        if (testArr.removeFirst() == (Object) 1)
            System.out.println(true);
        else
            System.out.println(false);
        testArr.addFirst(2);
        if (testArr.removeFirst() == (Object) 2)
            System.out.println(true);
        else
            System.out.println(false);
        testArr.addFirst(3);
        if (testArr.removeFirst() == (Object) 3)
            System.out.println(true);
        else
            System.out.println(false);
        try {
            testArr.removeFirst();
        } catch (NoSuchElementException ex) {
            System.out.println(true);
        }
    }

    private static void testRemoveLast() {
        System.out.println("TEST: REMOVE LAST");
        LinkedList testArr = new LinkedList();
        testArr.addLast(1);
        if (testArr.removeLast() == (Object) 1)
            System.out.println(true);
        else
            System.out.println(false);
        testArr.addLast(2);
        if (testArr.removeLast() == (Object) 2)
            System.out.println(true);
        else
            System.out.println(false);
        testArr.addLast(3);
        if (testArr.removeLast() == (Object) 3)
            System.out.println(true);
        else
            System.out.println(false);
        try {
            testArr.removeLast();
        } catch (NoSuchElementException ex) {
            System.out.println(true);
        }
    }

    private static void testIterator() {
        System.out.println("TEST: Iterator");
        LinkedList testArr = new LinkedList();
        for (int i = 0; i < 5; i++) {
            testArr.add(i);
        }
        Iterator<Object> it = testArr.iterator();
        if (it.next() == (Object) 0)
            System.out.println(true);
        else
            System.out.println(false);
        if (it.next() == (Object) 1)
            System.out.println(true);
        else
            System.out.println(false);
        if (it.next() == (Object) 2)
            System.out.println(true);
        else
            System.out.println(false);
        if (it.next() == (Object) 3)
            System.out.println(true);
        else
            System.out.println(false);
        if (it.next() == (Object) 4)
            System.out.println(true);
        else
            System.out.println(false);
        try {
            it.next();
        } catch (NoSuchElementException ex) {
            System.out.println(true);
        }
    }

}
