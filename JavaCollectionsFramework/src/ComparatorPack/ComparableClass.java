package JavaCollectionsFramework.ComparatorPack;

import java.util.*;

public class ComparableClass {
    public static void main(String[] args) {
        List<Person2> peopleList = new ArrayList<>();
        Set<Person2> peopleSet = new TreeSet<>();

        addElements(peopleList);
        addElements(peopleSet);

        System.out.println(peopleList);
        System.out.println(peopleSet);

        Collections.sort(peopleList);
        System.out.println(peopleList);

    }

    private static void addElements(Collection collection) {
        collection.add(new Person2(3, "Tommy"));
        collection.add(new Person2(4, "George"));
        collection.add(new Person2(1, "Bob"));
        collection.add(new Person2(2, "Nick"));
    }
}

class Person2 implements Comparable<Person2> { // интерфейс, с помощью которого объекты класса можно будет сравнивать
    private int id;
    private String name;

    public Person2(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person2 person2 = (Person2) o;
        return id == person2.id &&
                Objects.equals(name, person2.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Person2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Person2 o) {    // метод, сравнивающий объекты по id
        if (this.getId() > o.getId()) {
            return 1;
        } else if (this.getId() < o.getId()) {
            return -1;
        } else
            return 0;
    }
}
