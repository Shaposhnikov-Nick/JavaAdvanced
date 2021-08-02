package LambdaExpressions;

import java.util.stream.IntStream;

/*
Сгенерируйте последовательность чисел от 1 до 100 включительно, ограничьте ее последними 50 числами,
оставьте только те числа, которые делятся без остатка на 2 или на 5, и посчитайте сумму полученных чисел.
В ответе у вас должно выйти 2275.
 */
public class SFTask {
    public static void main(String[] args) {
        IntStream intStream = IntStream.rangeClosed(1, 100);
        int sum = intStream.skip(50).limit(50).filter(x -> x % 2 == 0 || x % 5 == 0).sum();
        System.out.println(sum);
    }
}
