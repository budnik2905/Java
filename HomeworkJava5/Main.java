//С использованием метода merge:

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, String> map1 = new HashMap<>();
        map1.put("key1", "value1");
        map1.put("key2", "value2");
        map1.put("key3", "value3");
        map1.put("key4", "value4");
        map1.put("key5", "value5");
        map1.put("key6", "value6");

        System.out.println("Before:");
        for (Map.Entry<String, String> entry : map1.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
            entry.setValue(entry.getValue() + "!");
        }

        Map<String, String> map2 = new HashMap<>();
        map2.put("key1", "newValue1");
        map2.put("key2", "value2");
        map2.put("key3", "newValue3");

        System.out.println("After:");
        map2.forEach((key, value) -> map1.merge(key, value, (v1, v2) -> v1 + v2));
        for (Map.Entry<String, String> entry : map1.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}

//Без использования метода merge:

        import java.util.HashMap;
        import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, String> map1 = new HashMap<>();
        map1.put("key1", "value1");
        map1.put("key2", "value2");
        map1.put("key3", "value3");
        map1.put("key4", "value4");
        map1.put("key5", "value5");
        map1.put("key6", "value6");

        System.out.println("Before:");
        for (Map.Entry<String, String> entry : map1.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
            entry.setValue(entry.getValue() + "!");
        }

        Map<String, String> map2 = new HashMap<>();
        map2.put("key1", "newValue1");
        map2.put("key2", "value2");
        map2.put("key3", "newValue3");

        System.out.println("After:");
        for (Map.Entry<String, String> entry : map2.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue() + "!";
            if (map1.containsKey(key)) {
                map1.put(key, map1.get(key) + value);
            } else {
                map1.put(key, value);
            }
        }
        for (Map.Entry<String, String> entry : map1.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
