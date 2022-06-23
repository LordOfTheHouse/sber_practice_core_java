package practice.collections;

public class TestArrayList {
    public static void main(String[] args) {
        ArrayList a = new ArrayList();
        a.add(4);
        a.add(7);
        a.add(8);
        a.add(10);
        a.add("jjk");
        a.add(4);
        a.add(4);
        a.add(4);
        a.add(4);
        a.add(4);
        a.add(4);
        a.add(4);
        System.out.println(a.get(4));
        System.out.println(a.contains(4));
        System.out.println(a.isEmpty());
        a.remove((Object)4);
        System.out.println(a.contains(4));
        for(int i = 0; i < a.size(); i++){
            System.out.println(a.get(i));
        }
        ArrayList p = (ArrayList) a.subList(2, 4);
        for(int i = 0; i < p.size(); i++){
            System.out.println(p.get(i));
        }
        p.set(2, "aloha");
        p.add(3, 10);
        for(int i = 0; i < p.size(); i++){
            System.out.println(p.get(i));
        }
        System.out.println(p.indexOf(10) + " " + p.lastIndexOf(10) + " " + a.indexOf(4));
    }
}
