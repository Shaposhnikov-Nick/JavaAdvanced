package JavaCollectionsFramework.HashMapPack;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>(); // Integer - ключ,String - значение

        map.put(1,"Один"); // кладем значения в map (ключ - значение). Не может быть двух одинаковых ключей
        map.put(2,"Два");
        map.put(3,"Три");
        System.out.println(map); // значения выводятся в случайном порядке!
        map.remove(2); // удаляем значение по ключу
        map.put(3,"Другое значение ключа три"); // кладем значение с существующим ключом (старое значение переписывается)
        System.out.println(map);

        System.out.println(map.get(1)); // получаем значение по ключу

        /*
        !!! Объекты выводятся не по порядку, а в случайном порядке. Упорядочить нельзя!
        Проходимся по всей структуре.
        Entry<Integer, String> - это каждая пара ключ - значение.
        map.entrySet() - метод, возвращающий набор всех пар ключ - значение
        entry.getKey()  - метод, возвращающий ключ
        entry.getValue() - метод, возвращающий значение
         */
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

    }
}
