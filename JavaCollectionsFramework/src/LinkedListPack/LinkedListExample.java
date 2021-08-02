package JavaCollectionsFramework.LinkedListPack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListExample {
    public static void main(String[] args) {
        List<Integer> linkedList = new LinkedList<>();

        linkedList.add(5); // добавляем элементы в список
        linkedList.add(7); // добавляем элементы в список (автоматически в конец списка)
        linkedList.add(1,6); // добавляем элемент в список в нужный индекс
        System.out.println(linkedList.size()); // получаем размер списка
        System.out.println(linkedList.get(1)); // получаем элемент из списка по его индексу
        linkedList.remove(1); // удаление элемента списка под определенным индексом

        List<Integer> arrayList = new ArrayList<>();
        measureTime(linkedList);
        measureTime(arrayList);
    }

    // метод, который считает время выполнения для LinkedList<> и ArrayList<>
    private static void measureTime(List<Integer> list) {

        for (int i = 0; i < 100000; i++) {
            list.add(i);
        }

        for (int j = 0; j < list.size(); j++) {
            list.get(j);
        }

        long start = System.currentTimeMillis(); // время старта метода

        for (int k = 0; k < 100000; k++) {
            list.add(0,k); // добавляем элемент в индекс 0, т.е. каждый новый элемент попадает в начало
        }

        long end = System.currentTimeMillis(); // время окончания метода

        System.out.println(end - start);

    }
}
