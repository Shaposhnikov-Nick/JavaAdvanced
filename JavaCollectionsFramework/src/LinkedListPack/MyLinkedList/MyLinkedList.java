package JavaCollectionsFramework.LinkedListPack.MyLinkedList;

import java.util.Arrays;

// односвязный список
public class MyLinkedList {
    private Node head;
    private int size;

    public void add(int value) { // добавление в список
        // если это первое добавление в список
        if (head == null) {
            this.head = new Node(value);
        } else {
            Node temp = head; // временный узел

            while (temp.getNext() != null) {
                temp = temp.getNext();  // в результате temp указывает на последний элемент в списке
            }
            temp.setNext(new Node(value)); // создаем новый следующий узел
        }
        size++;
    }

    public int get(int index) { // получение значения списка по индексу
        int currentIndex = 0; // указывает на текущий индекс
        Node temp = head;

        while (temp != null) {
            if (currentIndex == index) {
                return temp.getValue();
            } else {
                temp = temp.getNext();
                currentIndex++;
            }
        }
        throw new IllegalArgumentException();

    }

    public void remove(int index) {
        if (index == 0) {
            head = head.getNext();
            size--;
            return;
        }
        int currentIndex = 0; // указывает на текущий индекс
        Node temp = head;

        while (temp != null) {
            if (currentIndex == index -1) {
                temp.setNext(temp.getNext().getNext());
                size--;
                return;
            } else {
                temp = temp.getNext();
                currentIndex++;
            }
        }
    }

    public String toString() {
        int[] result = new int[size];
        int idx = 0;
        Node temp = head;

        while (temp != null) {
            result[idx++] = temp.getValue();
            temp = temp.getNext();
        }

        return Arrays.toString(result);
    }

    private static class Node {
        private int value; // значение, хранящееся в этом узле
        private Node next; // ссылка на следующий узел

        public Node(int value) {
            this.value = value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public int getValue() {
            return value;
        }

        public Node getNext() {
            return next;
        }
    }
}
