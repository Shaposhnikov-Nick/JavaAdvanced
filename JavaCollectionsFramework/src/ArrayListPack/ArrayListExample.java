package JavaCollectionsFramework.ArrayListPack;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) { // добавляем элементы в массив
            list.add(i);
        }

        list.add(10, 58); // добавляем элементы в массив под нужным индексом

        System.out.println("HashCode: " + list.hashCode()); // выводит hashCode

        System.out.println(list.indexOf(25)); // выводит значение соответсвующего индекса, либо -1 если такого объекта нет

        System.out.println(list.lastIndexOf(5));

        System.out.println(list); // выводим массив

        System.out.println("Первый элемент массива " + list.get(0));  // получаем элемент из массива по его индексу
        
        System.out.println("Последний элемент массива " + list.get(list.size() - 1));

        System.out.println("Размер массива " + list.size()); // получаем размер массива

        for (int i = 0; i < list.size(); i++) { //проходим по всем элементам массива
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        for (Integer x : list) {  //проходим по всем элементам массива
            System.out.print(x + " ");
        }
        System.out.println();


        list.remove(5); // удаление элемента массива под определенным индексом
        System.out.println(list);

        // в параметре можем указывать размер создаваемого массива (по умолчанию 10)
        List<String> arrayString = new ArrayList<>(250);
        System.out.println(arrayString.size());

    }
}
