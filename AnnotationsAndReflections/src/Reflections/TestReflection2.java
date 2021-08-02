package Reflections;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class TestReflection2 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException,
            IllegalAccessException, InstantiationException, InvocationTargetException {

        Scanner scanner  = new Scanner(System.in);

        // Название класса 1 название класса_2 Название_метода
        Class classObject1 = Class.forName(scanner.next()); // создаем класс из консоли
        Class classObject2 = Class.forName(scanner.next()); // создаем класс из консоли
        String methodName = scanner.next();

        Method m = classObject1.getMethod(methodName, classObject2); // получаем метод, в параметры передаем название метода и второй объект

        // создаем обект первого класса с пустым конструктором
        Object o1 = classObject1.newInstance();

        // создаем объект второго класса и передаем данные в конструктор
        Object o2 = classObject2.getConstructor(String.class).newInstance("String value");

        //вызываем метод на объекте о1 с параметром о2
        m.invoke(o1, o2);

        System.out.println(o1);
    }
}
