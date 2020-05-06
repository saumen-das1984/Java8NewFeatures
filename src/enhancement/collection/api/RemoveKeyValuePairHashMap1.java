package enhancement.collection.api;

import java.util.HashMap;
import java.util.Map;

public class RemoveKeyValuePairHashMap1 {
    public static void main(String[] args) {

        // create two hashmap
        Map < String, Integer > courseMap = new HashMap < String, Integer > ();
        courseMap.put("Java", 1);
        courseMap.put("C", 2);
        courseMap.put("C++", 3);
        System.out.println("Before removal");
        printMap(courseMap);

        // using normal remove method
        courseMap.remove("Java");
        System.out.println("After removal");
        printMap(courseMap);
    }

    private static void printMap(Map < String, Integer > courseMap) {
        for (String s: courseMap.keySet()) {
            System.out.println(s);
        }

    }
}
