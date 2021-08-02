package JavaCollectionsFramework.StackPack;

import java.util.Stack;

public class StackClass {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5); // добавление элемента в стек
        stack.push(3);
        stack.push(1);

        System.out.println(stack.elementAt(0));
        System.out.println(stack.peek()); // достает и НЕ удаляет последний добавленный элемент из стека
        System.out.println(stack.pop()); // достает и удаляет последний добавленный элемент из стека
        System.out.println(stack.empty()); // true - если стек пустой, false - если стек имеет элементы

        while (!stack.empty()) { // выводим элементы пока стек не станет пустым
            System.out.println(stack.pop());
        }
    }
}
