package practice.collectionsMap;

import practice.collections.*;

public class HashMap implements Map{

    private LinkedList[] buckets;
    private int capacity;
    private int size;
    

    public HashMap(){
        capacity = (int) Math.pow(2, 20);
        size = 0;
        buckets = new LinkedList[capacity];
    }

    @Override
    public void clear() {
        size = 0;
        buckets = new LinkedList[capacity];
    }

    @Override
    public boolean containsKey(Object key) {
        for(LinkedList li: buckets){
            if(li != null){
                for (int i = 0; i < li.size(); i++) {
                    if(((Entry)li.get(i)).getKey().equals(key)){
                        return true;
                    }
                }
        }
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for(LinkedList li: buckets){
            if(li != null){
                for (int i = 0; i < li.size(); i++) {
                    Object buff = ((Entry)li.get(i)).getValue();
                    if(buff == null && value == null){
                        return true;
                    }else if(buff == null){
                        continue;
                    }else if(buff.equals(value)){
                        return true;
                    }
                    
                }
            }
        }
        return false;
    }

    @Override
    public Collection entrySet() {
        ArrayList entry = new ArrayList();
        for (LinkedList li : buckets) {
            if(li != null){
                for (int i = 0; i < li.size(); i++) {
                    entry.add(li.get(i));
                }
            }
        }
        return entry;
    }

    @Override
    public Object get(Object key) {
        int bucketNumber = key.hashCode() % buckets.length;
        LinkedList list = buckets[bucketNumber];
        for(int i = 0; i < list.size(); i++){
            if(((Entry) list.get(i)).getKey().equals(key)){
                return ((Entry) list.get(i)).getValue();
            }
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        if(size == 0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Collection keySet() {
        ArrayList keys = new ArrayList();
        for (LinkedList li : buckets) {
            if(li != null){
                for (int i = 0; i < li.size(); i++) {
                    keys.add(((Entry)li.get(i)).getKey());
                }
            }
        }
        return keys;
    }

    @Override
    public Object put(Object key, Object value) {  
        int bucketNumber = key.hashCode() % buckets.length;
        var list = buckets[bucketNumber];
        if(list != null){
            for(int i = 0; i < list.size(); i++){
                if(((Entry) list.get(i)).getKey().equals(key)){
                    ((Entry) list.get(i)).setValue(value);
                    return new Entry(key, value);
                }
            }
        }else{
            list = new LinkedList();
        }
        list.addLast(new Entry(key, value));
        buckets[bucketNumber] = list;
        size++;
        return new Entry(key, value);
    }

    @Override
    public Object remove(Object key) {
        for (LinkedList li : buckets) {
            if(li != null){
                for (int i = 0; i < li.size(); i++) {
                    if(((Entry)li.get(i)).getKey().equals(key)){
                        size--;
                        return ((Entry) li.remove(i)).getValue();
                    }
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Collection values() {
        ArrayList vals = new ArrayList();
        for (LinkedList li : buckets) {
            if(li != null){
                for (int i = 0; i < li.size(); i++) {
                    vals.add(((Entry)li.get(i)).getValue());
                }
            }
        }
        return vals;
    }
    
}
