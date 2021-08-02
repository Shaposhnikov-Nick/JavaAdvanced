package LambdaExpressions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StringComparatorLambda {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("Hello");
        list.add("GoodBye");
        list.add("a");
        list.add("ab");

//        list.sort(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.length() - o2.length();
//            }
//        });
//        System.out.println(list);

        list.sort((s1, s2) -> s1.length() - s2.length());
        System.out.println(list);

    }
}
