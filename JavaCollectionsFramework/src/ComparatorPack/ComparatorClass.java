package JavaCollectionsFramework.ComparatorPack;

import java.util.*;

public class ComparatorClass {
    public static void main(String[] args) {
        List<String> animals = new ArrayList<>();

        animals.add("Frog12");
        animals.add("Dog1");
        animals.add("Cat");
        animals.add("Bird22443");
        animals.add("Elephant131323");

        Collections.sort(animals); // метод коллекций, сортирующий объекты внутри коллекции лексикографически
        System.out.println(animals);

        Collections.sort(animals, new StringLengthComparator()); // сортируем по длинне строки, для этого создаем
        System.out.println(animals);                             // класс StringLengthComparator

        //////////////////////////////////////////////////////////////

        List<Integer> numbers = new ArrayList<>();

        numbers.add(5);
        numbers.add(500);
        numbers.add(-52);
        numbers.add(0);
        numbers.add(85);

        Collections.sort(numbers); // сортировка чисел по возрастанию (стандартная)
        System.out.println(numbers);

        Collections.sort(numbers, new Comparator<Integer>() {  // сортируем числа по убыванию с помощью анонимного класса
            @Override
            // чтобы не создавать отдельный класс для разовой операции
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2) {
                    return -1;
                } else if (o1 < o2) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        System.out.println(numbers);

        /////////////////////////////////////////////////////////////

        List<Person> people = new ArrayList<>();

        people.add(new Person(2, "Tom"));
        people.add(new Person(1, "Bob"));
        people.add(new Person(3, "Jack"));

        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if (o1.getId() > o2.getId()) {
                    return 1;
                } else if (o1.getId() < o2.getId()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        System.out.println(people);

    }
}


class StringLengthComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        /*
        конвенция
        if o1 > o2 return 1;
        if o1 < o2 return -1;
        if o1 == o2 return 0;
         */

        if (o1.length() > o2.length()) {
            return 1;
        } else if (o1.length() < o2.length()) {
            return -1;
        } else {
            return 0;
        }
    }
}

class Person {
    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

