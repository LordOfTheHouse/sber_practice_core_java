package practice.collections;

import java.util.*;

public class TestArrayList {
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
        testIterator();
    }

    private static void testGet() {
        System.out.println("TEST: GET");
        ArrayList<Integer> testArr = new ArrayList<>();
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
        ArrayList<Integer> testArr = new ArrayList<>();
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
        ArrayList<Integer> testArr = new ArrayList<>();
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
        ArrayList<Integer> testArr = new ArrayList<>();
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
        } catch (IndexOutOfBoundsException ex) {
            System.out.println(true);
        }
    }

    private static void testSet() {
        System.out.println("TEST: SET");
        ArrayList<Integer> testArr = new ArrayList<>();
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
        } catch (IndexOutOfBoundsException ex) {
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
        ArrayList<Integer> testArr = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            testArr.add(i);
        }
        ArrayList<Integer> testSubList1 = 
            (ArrayList<Integer>) testArr.subList(1, 2);
        ArrayList<Integer> testSubList2 = 
            (ArrayList<Integer>) testArr.subList(2, 4);
        ArrayList<Integer> testSubList3 = 
            (ArrayList<Integer>) testArr.subList(0, 4);
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
        ArrayList<Integer> testArr = new ArrayList<>();
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
        ArrayList<Integer> testArr = new ArrayList<>();
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
        ArrayList<Integer> testArr = new ArrayList<>();
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

    private static void testIterator() {
        System.out.println("TEST: Iterator");
        ArrayList<Integer> testArr = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            testArr.add(i);
        }
        Iterator<Integer> it = testArr.iterator();
        if (it.next() == 0)
            System.out.println(true);
        else
            System.out.println(false);
        if (it.next() == 1)
            System.out.println(true);
        else
            System.out.println(false);
        if (it.next() == 2)
            System.out.println(true);
        else
            System.out.println(false);
        if (it.next() == 3)
            System.out.println(true);
        else
            System.out.println(false);
        if (it.next() == 4)
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
