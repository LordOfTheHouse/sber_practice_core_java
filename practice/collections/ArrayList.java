package practice.collections;

public class ArrayList implements List {

    private Object[] obj;
    private int capacity;
    private int size;

    public ArrayList(ArrayList aList) {
        obj = aList.getObj();
        capacity = aList.getCapacity();
        size = aList.getSize();
    }

    public ArrayList() {
        capacity = 10;
        obj = new Object[capacity];
        size = 0;
    }
    
    public void setSize(int s){
        size = s;
    }

    @Override
    public void add(int index, Object item) {
        if (size == capacity){
            obj = copyList();
        }
        try{
            if(index > size || index < 0){
                throw new IndexOutOfBoundsException();
            }else if(index == size){
                obj[index] = item; 
                size++;
            }else{
                for(int i=size; i>index;i--){
                    obj[i] = obj[i-1];
                }
                obj[index] = item;
                size++;
            }
        }catch(IndexOutOfBoundsException ex){
            ex.printStackTrace();
        } 
    }

    @Override
    public Object get(int index) {
        try {
            if (index >= size) {
                throw new IndexOutOfBoundsException();
            } else {
                return obj[index];
            }
        } catch (IndexOutOfBoundsException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public int indexOf(Object item) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (obj[i].equals(item)) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public int lastIndexOf(Object item) {
        int index = -1;
        for (int i = size - 1; i >= 0; --i) {
            if (obj[i].equals(item)) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public Object remove(int index) {
        try{
            if(index>=size || index < 0 || isEmpty()){
                throw new IndexOutOfBoundsException();
            }else{        
                Object el = obj[index];
                for(int i = index; i < size; i++){
                    obj[i] = obj[i+1];
                }
                size--;
                return el;
            }

        }catch(IndexOutOfBoundsException ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public void set(int index, Object item) {
        try {
            if (index < size && index >= 0) {
                obj[index] = item;
            }else if(index == size){
                add(item);
            } else {
                throw new IndexOutOfBoundsException();
            }
        } catch (IndexOutOfBoundsException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List subList(int from, int to) { 
        try{
            if(to > size){
                throw new IndexOutOfBoundsException();
            }else{
                ArrayList subObj = new ArrayList();
                for(int i = from; i < to; i++){
                    subObj.add(obj[i]);
                }
                return subObj;
            }
        }catch (IndexOutOfBoundsException ex) {
            ex.printStackTrace();
        }
        return new ArrayList();
        
    }

    @Override
    public boolean add(Object item) {
        if (size < capacity) {
            obj[size] = item;
        } else {
            Object[] obj2 = copyList();
            obj2[size] = item;
            obj = obj2;
        }
        size++;
        return true;
    }

    private Object[] copyList() {
        capacity = (capacity * 3) / 2 + 1;
        Object[] obj2 = new Object[capacity];
        for (int i = 0; i < size; i++) {
            obj2[i] = obj[i];
        }
        return obj2;
    }

    @Override
    public void clear() {
        capacity = 10;
        obj = new Object[capacity];
        size = 0;
    }

    @Override
    public boolean contains(Object item) {
        for (Object el : obj) {
            if (item.equals(el)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object item) {
        if(!contains(item)){
            return false;
        }
        for(int i = 0; i<size; i++){
            if(obj[i].equals(item)){
                remove(i);
                remove(item);
                break;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    public Object[] getObj() {
        return obj;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }
}
