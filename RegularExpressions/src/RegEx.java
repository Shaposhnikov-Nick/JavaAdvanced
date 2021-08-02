
import java.util.Arrays;

public class RegEx {
    public static void main(String[] args) {
        /*
        \\d - одна цифра
        \\w = [a-zA-Z] - одна английская буква
        -\\d - учитывает отрицательные числа
        + - может быть 1 или более символов
        * - может быть 0 или более символов
        ? - 0 или 1 символ который идет до ? может быть,  а может не быть
        ( | | ) - между | указываем то, что может быть в строке
        [] - описание большого множества, которое может быть в строке, например;
                        [abc] = (a|b|c) - то есть только a, b или c
                        [a-z] - весь алфавит строчные буквы
                        [a-zA-Z] - весть алфавит строчные и заглавные буквы
                        [0-9] = \\d - цифры от 0 до 9
        [^abc] - могут быть все символы, кроме указанных после знака^
        . - любой символ (.+ - 1 или более любых символов)
        {2} - точное количество символов до (\\d{2})
        {2,} - 2 или более символов (\\d{2,})
        {2, 4} - от 2 до 4 симолов (\\d{2,4})
         */
        String a = "91";
        System.out.println(a.matches("\\d+")); // метод matches сравнивает строку с той, что указана в аргументе

        String b = "-1456";
        System.out.println(b.matches("-?\\d+"));

        String e = "+4536";
        System.out.println(e.matches("(-|\\+|)?\\d*"));

        String c  ="dldn12343";
        System.out.println(c.matches("[a-zA-Z]+\\d*"));

        String d  ="ae3g5we12343hjkkpj55";
        System.out.println(c.matches("[a-zA-Z35]+\\d*"));

        String f = "sdf";
        System.out.println(f.matches("[^abc]*"));

        String url = "http://www.google.com"; // проверяем валидный ли адрес веб сайта
        System.out.println(url.matches("http://www\\..+\\.(com|ru)"));

        String email = "kolek5@rambler.ru"; // проверяем валидный ли адрес электронной почты
        System.out.println(email.matches("[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.(com|ru)"));

        String g = "123";
        System.out.println(g.matches("\\d{2}"));

        ////////////////////////////////////
        String h = "Hello their hey";
        String[] words = h.split(" ");
        System.out.println(Arrays.toString(words));

        String i = "2132hello495u959my483d39friends"; // выделяем из строки только слова или буквы
        words = i.split("\\d+");
        System.out.println(Arrays.toString(words));

        ///////////////////////////////////////
        String j = "Hello their hey"; // replace() не принимает регулярные выражения в качестве аргумента
        System.out.println(j.replace(" ", "."));

        String k = "12212lfawfl23123els32sdd"; // replaceAll() принимает регулярные выражения в качестве аргумента
        System.out.println(k.replaceAll("\\d+", "-"));

        String l = "12ewr132weds122"; // replaceFirst() заменят первое совпадение регулярного выражения в строке
        System.out.println(l.replaceFirst("\\d{3,}", "-"));
    }
}
