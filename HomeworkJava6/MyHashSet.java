import java.util.*;

public class MyHashSet {
    private ArrayList<Integer> elements;

    public MyHashSet() {
        elements = new ArrayList<Integer>();
    }

    public boolean add(Integer element) {
        if (!contains(element)) {
            elements.add(element);
            return true;
        }
        return false;
    }

    public boolean contains(Integer element) {
        return elements.contains(element);
    }

    public Integer get(int index) {
        if (index >= 0 && index < elements.size()) {
            return elements.get(index);
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < elements.size(); i++) {
            sb.append(elements.get(i));
            if (i != elements.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}

    //Пример использования:

        MyHashSet set = new MyHashSet();
        set.add(1);
        set.add(2);
        set.add(3);
        System.out.println(set); // [1, 2, 3]
        System.out.println(set.get(1)); // 2