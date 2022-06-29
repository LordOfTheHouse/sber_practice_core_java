package practice.collectionsMap;

public class TestHashMap {
    public static void main(String[] args) {
        HashMap hm = new HashMap();
        hm.put(1, "1");
        hm.put(2, "2");
        hm.put(9, "3");
        hm.put(9, "15");
        hm.put(12, "4");
        hm.put(19, null);
        hm.put(15, "5");
        hm.put("do", "6");
        hm.put(2235, "dfsdf");

        System.out.println("Test GET");
        System.out.println(hm.get(1));
        System.out.println(hm.get(2));
        System.out.println(hm.get("do"));
        System.out.println(hm.get(2235));
        System.out.println("Test CONTAINS VALUE");
        System.out.println(hm.containsValue("2"));
        System.out.println(hm.containsValue("4"));
        System.out.println(hm.containsValue("dfsdf"));
        System.out.println(hm.containsValue("7"));
        System.out.println("Test CONTAINS KEY");
        System.out.println(hm.containsKey(9));
        System.out.println(hm.containsKey(2235));
        System.out.println(hm.containsKey("do"));
        System.out.println(hm.containsValue("321"));
        System.out.println("Test VALUES");
        for (Object el : hm.values()) {
            System.out.println(el);
        }
        System.out.println("Test KEY SET");
        for (Object el : hm.keySet()) {
            System.out.println(el);
        }
        System.out.println("Test KEY EMPTY");
        for (Object el : hm.entrySet()) {
            System.out.println(el);
        }
        System.out.println("Test SIZE + REMOVE + CLEAR");
        System.out.println("size: " + hm.size());
        System.out.println("remove: " + hm.remove(15));
        System.out.println("size: " + hm.size());
        System.out.println("remove: " + hm.remove(19));
        System.out.println("size: " + hm.size());
        hm.clear();
        System.out.println("clear");
        System.out.println("size: " + hm.size());

    }
}
