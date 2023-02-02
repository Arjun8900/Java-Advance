package hashMap;

import java.util.*;
import java.util.stream.Collectors;

public class HashMaps {
    public static void main(String[] args) {
        basics();
        iteratingHashMap1();
        iteratingHashMap2();

        tripletMap();
    }

    private static void basics() {
        Map<String, String> map = new HashMap<>();

        String earlyCreation = map.putIfAbsent("key1", new String("Always Created"));// Early creation | Put NULL object also
        System.out.println(earlyCreation); // This will return null
        String lazyCreation = map.computeIfAbsent("key2", k -> new String("Created only if key is not present")); // Lazy creation | Will not Put NULL object
        System.out.println(lazyCreation); // This will return `Created only if key is not present`

        String replacedValue = map.replace("key3", "value");// Replaces value only if it is present.
        System.out.println(replacedValue);
        System.out.println(map);

    }

    private static void tripletMap() {
        List<String> lists = Arrays.asList("Arjun", "Part");
        Map<String, Map.Entry<String, String>> triplet = lists.stream().collect(Collectors.toMap(val -> getPackageDir("USR", val),
                        val -> new AbstractMap.SimpleImmutableEntry<>(getPackageDir("", val), getPackageDir("", val))));
        System.out.println(triplet);
    }

    public static String getPackageDir(String a, String val) {
        return a + " -> " + val;
    }

    private static void iteratingHashMap1() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Arjun");
        map.put(2, "Arjun2");
        for (Map.Entry<Integer, String> m: map.entrySet()) {
            int key = m.getKey();
            String val = m.getValue();
            System.out.printf("Key = %s, Value = %s %n", key, val);
        }
    }

    private static void iteratingHashMap2() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Arjun");
        map.put(2, "Arjun2");
        for (int key: map.keySet()) {
            String val = map.get(key);
            System.out.printf("Key = %s, Value = %s %n", key, val);
        }

    }
}
