package practice.collectionsMap;

import practice.collections.ArrayList;

public class TestHashMap {
    public static void main(String[] args) {
        HashMap hm = new HashMap();
        hm.put("a", 1);
        hm.put("b", 17);
        hm.put("c", "gf");
        hm.put("sdf", 2);
        hm.put("e", 5);
        hm.put("f", 5);
        hm.put("sdf", 5);
        System.out.println();
        System.out.println(hm.containsKey("sdf"));
        System.out.println(hm.containsValue("gf"));
        hm.remove("a");
        ArrayList li = (ArrayList) hm.values();
        for (Object el : li) {
            System.out.println(el);
        }
        
    }
}
