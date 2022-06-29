package practice.collectionsMap;

public class TestTreeMap {
    public static void main(String[] args) {
        TreeMap tm = new TreeMap();
        tm.put(1, "1");
        tm.put(2, "2");
        tm.put(9, "3");
        tm.put(9, "15");
        tm.put(12, "4");
        tm.put(19, null);
        tm.put(15, "5");
        tm.put("do", "6");
        tm.put(2235, "dfsdf");

        System.out.println("Test GET");
        System.out.println(tm.get(1));
        System.out.println(tm.get(2));
        System.out.println(tm.get("do"));
        System.out.println(tm.get(2235));
        System.out.println("Test CONTAINS VALUE");
        System.out.println(tm.containsValue("2"));
        System.out.println(tm.containsValue("4"));
        System.out.println(tm.containsValue("dfsdf"));
        System.out.println(tm.containsValue("7"));
        System.out.println("Test CONTAINS KEY");
        System.out.println(tm.containsKey(9));
        System.out.println(tm.containsKey(2235));
        System.out.println(tm.containsKey("do"));
        System.out.println(tm.containsValue("321"));
        System.out.println("Test VALUES");
        for (Object el : tm.values()) {
            System.out.println(el);
        }
        System.out.println("Test KEY SET");
        for (Object el : tm.keySet()) {
            System.out.println(el);
        }
        System.out.println("Test KEY EMPTY");
        for (Object el : tm.entrySet()) {
            System.out.println(el);
        }
        System.out.println("Test SIZE + REMOVE + CLEAR");
        System.out.println("size: " + tm.size());
        System.out.println("remove: " + tm.remove(15));
        System.out.println("size: " + tm.size());
        System.out.println("remove: " + tm.remove(19));
        System.out.println("size: " + tm.size());
        tm.clear();
        System.out.println("clear");
        System.out.println("size: " + tm.size());

    }
}
