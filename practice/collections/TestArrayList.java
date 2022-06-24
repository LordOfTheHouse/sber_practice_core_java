package practice.collections;

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
    }

    private static void testGet() {
        System.out.println("TEST: GET");
        ArrayList testArr = new ArrayList();
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
        ArrayList testArr = new ArrayList();
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
        ArrayList testArr = new ArrayList();
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
        ArrayList testArr = new ArrayList();
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
        ArrayList testArr = new ArrayList();
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
        ArrayList testArr = new ArrayList();
        for (int i = 0; i < 5; i++) {
            testArr.add(i);
        }
        ArrayList testSubList1 = (ArrayList) testArr.subList(1, 2);
        ArrayList testSubList2 = (ArrayList) testArr.subList(2, 4);
        ArrayList testSubList3 = (ArrayList) testArr.subList(0, 4);
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
        ArrayList testArr = new ArrayList();
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
        ArrayList testArr = new ArrayList();
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
        ArrayList testArr = new ArrayList();
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

}
