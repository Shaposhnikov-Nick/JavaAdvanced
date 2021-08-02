package JavaCollectionsFramework.QueuePack;

import java.util.LinkedList;
import java.util.Queue;

public class QueueClass {
    public static void main(String[] args) {

        Person person1 = new Person(1);
        Person person2 = new Person(2);
        Person person3 = new Person(3);
        Person person4 = new Person(4);

        Queue<Person> people = new LinkedList<>();
        people.add(person3);
        people.add(person2);
        people.add(person4);
        people.add(person1);
        people.remove(person1);

        for (Person person : people) //выводится в том же порядке, в котором зали в очередь
            System.out.println(person);

    }
}

class Person {
    int id;

    public Person(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                '}';
    }
}