package LambdaExpressions;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        int[] arr = new int[10];
        List<Integer> list = new ArrayList<>();

        fillArray(arr);
        fillList(list);

        System.out.println(list);
        System.out.println(Arrays.toString(arr));

        /*
        map method: (итерация)
        переводим массив в stream
        map() итерируется по набору элементов
        а - на каждой итерации является элементом
        toArray() - возвращает stream в массив
        collect(Collectors.toList())- возвращает stream в коллекцию
         */
        arr = Arrays.stream(arr).map(a -> a * 2).toArray();
        list = list.stream().map(a -> a * 2).collect(Collectors.toList());

        System.out.println(list);
        System.out.println(Arrays.toString(arr));

        /*
        filter method:
        filter() - возвращает true если выполняется условие в лямбде, или false, если условие не выполняется,
        оставляет только те элементы, которые соответствуют true
         */
        int[] arr2 = new int[10];
        List<Integer> list2 = new ArrayList<>();

        fillArray(arr2);
        fillList(list2);

        arr2 = Arrays.stream(arr2).filter(a -> a % 2 == 0).toArray();
        list2 = list2.stream().filter(a -> a % 2 == 0).collect(Collectors.toList());

        System.out.println(Arrays.toString(arr2));
        System.out.println(list2);

        /*
        forEach method:
        просто итератор
         */

        Arrays.stream(arr2).forEach(System.out::print);
        list2.stream().forEach(System.out::print);
        System.out.println();

        /*
        reduce method
        сжимает набор данных в один элемент (например, сумма элементов)
        getAsInt()  - преобразует полученный stream() в int
         */
        int[] arr3 = new int[10];
        List<Integer> list3 = new ArrayList<>();

        fillArray(arr3);
        fillList(list3);

        int sum1 = Arrays.stream(arr3).reduce((acc, b) -> acc + b).getAsInt();
        int prod = list3.stream().reduce((acc, b) -> acc * b).get();
        System.out.println("Sum = " + sum1);
        System.out.println("Sum = " + prod);

        /*
        Several methods
         */

        int[] arr4 = new int[10];
        fillArray(arr4);

        arr4  = Arrays.stream(arr4).filter(a -> a % 2 !=0).map(a -> a * 2).toArray();
        System.out.println(Arrays.toString(arr4));

        /*
        используется с любой коллекцией
         */

        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);

        set = set.stream().map(a -> a * 3).collect(Collectors.toSet());
        System.out.println(set);

        //////////////////////////////////////////////
        Stream<Integer> infinite = Stream.iterate(2, x -> x * 2);
        System.out.println(infinite.anyMatch(test -> test / 8 == 0));

        ////////////////////////////////////////////
        Stream<Integer> stream = Stream.iterate(1, integer -> integer + 1);
        boolean match = stream
                .map(String::valueOf)
                .distinct()
                .limit(5)
                .noneMatch(str -> str.length() != 1);
        System.out.println(match);

        ///////////////////////////////////////////
        /*
        без стримов переводим строки в числа и перемножаем
         */
        List<String> listString = Arrays.asList("10", "20", "30");
        List<Integer> listInt = new ArrayList<>();
        Integer sum = 1;
        for (int i = 0; i < listString.size(); i++) {
            listInt.add(Integer.parseInt(listString.get(i)));
        }

        for (Integer x : listInt) {
            sum *= x;
        }

        System.out.println(sum);

        /*
        со стримами
         */

        List<String> listString2 = Arrays.asList("10", "20", "30");
        int sum3 = listString2.stream().map(Integer::parseInt).reduce(1,(acc, b) -> acc * b);
        System.out.println(sum3);

        /////////////////////////////////////////////


    }

    private static void fillList(List<Integer> list) {
        for (int i = 0; i < 10; i++) {
            list.add(i + 1);
        }
    }

    private static void fillArray(int[] arr) {
        for (int i = 0; i < 10; i++) {
            arr[i] = i + 1;
        }
    }
}
