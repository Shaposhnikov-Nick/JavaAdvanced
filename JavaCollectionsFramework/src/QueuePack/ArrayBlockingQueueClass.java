package JavaCollectionsFramework.QueuePack;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBlockingQueueClass {
    public static void main(String[] args) {

        Person person5 = new Person(5);
        Person person6 = new Person(6);
        Person person7 = new Person(7);
        Person person8 = new Person(8);

        Queue<Person> people = new ArrayBlockingQueue<Person>(10); // обязатель указать максимальную длину очереди!!
        people.add(person6);
        people.add(person5);
        people.add(person8);
        people.add(person7);

        System.out.println(people.remove()); // достает и удаляет первый элемент в очереди
        System.out.println(people.peek()); // достает и НЕ удаляет первый элемент в очереди
        System.out.println(people);

    }
}
