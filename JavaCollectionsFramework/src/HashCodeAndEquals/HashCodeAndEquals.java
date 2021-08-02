package JavaCollectionsFramework.HashCodeAndEquals;

import java.util.*;

public class HashCodeAndEquals {
    public static void main(String[] args) {
        Map<Person, String> map = new HashMap<>();
        Set<Person> set = new HashSet<>();

        Person person1 = new Person(32, "Tom");
        Person person2 = new Person(32, "Tom");

        map.put(person1, "123");
        map.put(person2, "123");

        set.add(person1);
        set.add(person2);

        System.out.println(map);
        System.out.println(set);
    }
}

class Person {
    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    /*
    hashCode вызывается первым (быстрый метод) при сравнении объектов
    если по хэш коды у объектов разные -> объекты разные,
    если по хэш коды у объектов одинаковые, то вызывается метод equals (более медленный метод
    сравнивающий объекты по их полям) для дополнительной проверки, т.к. могу случиться коллизии,
    то есть два разных объекта могут иметь одинаковый хэш код.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id &&
                name.equals(person.name);
    }

}
