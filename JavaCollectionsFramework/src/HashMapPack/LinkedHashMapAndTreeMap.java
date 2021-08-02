package JavaCollectionsFramework.HashMapPack;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class LinkedHashMapAndTreeMap {
    public static void main(String[] args) {

        // HashMap -  внутри не гарантируется никакого порядка
        Map<Integer, String> hashMap = new HashMap<>();

        // LinkedHashMap - в каком порядке пары ключ-значение были добавлены, в таком порядке они и вернутся
        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();

        // TreeMap - пары ключ-значение будут отсортированы по ключу (лексикографический порядок)
        Map<Integer, String> treeMap = new TreeMap<>();

        testMap(hashMap);
        testMap(linkedHashMap);
        testMap(treeMap);


    }

    // тестирование видов map
    public static void testMap(Map<Integer, String> map) {
        map.put(39,"Bob");
        map.put(25,"Nick");
        map.put(14,"Tom");
        map.put(42,"Ken");
        map.put(21,"Tim");
        map.put(71,"Rot");

        for (Map.Entry<Integer,String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        System.out.println();
    }
}
