package LambdaExpressions.SFModule14;

import java.util.Scanner;

public class Main {

    static String changeStr(StringFunc sf, String str) {
        return sf.func(str);
    }

    public static void main(String[] args) {
        String inString;
        String outString;
        StringFunc revers;

        System.out.println("Введите строку:");
        Scanner scanner = new Scanner(System.in);
        inString = scanner.nextLine();

        if (inString.equals("")) {
            System.out.println("Пустая строка");
            inString = "Пустая строка";
        }

        revers = (str) -> {
            String result = "";

            for (int i = str.length() - 1; i >= 0; i--) {
                result += str.charAt(i);
            }
            return result;
        };

        outString = changeStr(revers, inString);
        System.out.println("Строка в обратном порядке:\n" + outString);

        outString = changeStr((str) -> str.replace(" ", "-"), inString);
        System.out.println("Строка с замененными пробелами:\n" + outString);
    }
}

interface StringFunc {
    String func(String str);
}