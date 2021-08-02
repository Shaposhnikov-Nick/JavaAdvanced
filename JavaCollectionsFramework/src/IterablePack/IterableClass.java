package JavaCollectionsFramework.IterablePack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IterableClass {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);

        // before Java 5
        Iterator<Integer> iterator = list.iterator();

        int idx = 0;
        while (iterator.hasNext()){ //hasNext() возвращает true если еще есть объекты, false - если объектов нет
            System.out.println(iterator.next()); // next() возвращает следующий в списке объект

            if (idx == 1)  // удаляем элемент под индексом 1
                iterator.remove();

            idx++;
        }

        // Java 5
        for (Integer x : list) {
            System.out.println(x);
        }
    }
}
