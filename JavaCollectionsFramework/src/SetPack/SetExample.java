package JavaCollectionsFramework.SetPack;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

// В Set хранятся только разные элементы!
public class SetExample {
    public static void main(String[] args) {

        // HashSet -  внутри не гарантируется никакого порядка
        Set<String> hashSet = new HashSet<>();

        // LinkedHasSet - в каком порядке значения были добавлены, в таком порядке они и вернутся
        Set<String> linkedHasSet = new LinkedHashSet<>();

        // TreeSet - значения будут отсортированы по ключу (лексикографический порядок)
        Set<String> treeSet = new TreeSet<>();

        hashSet.add("Nick");
        hashSet.add("Daria");
        hashSet.add("Karolina");
        hashSet.add("Karolina"); // два одинаковых объекта нельзя хранить в одном множестве
        hashSet.add("D");
        hashSet.remove("D"); // удаление


        for (String name : hashSet) { // выводим множество
            System.out.println(name);
        }

        System.out.println(hashSet.contains("Nick")); // возвращает true если данный объект есть в множестве
        System.out.println(hashSet.contains("Tom")); // возвращает false если данного объекта нет в множестве
        System.out.println(hashSet.isEmpty()); // возвращает false если множество не пустое
        System.out.println(linkedHasSet.isEmpty()); // возвращает true если множество пустое

    }
}
