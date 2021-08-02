
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternAndMatcher {
    public static void main(String[] args) {
        String text = "aewfav89va8rv9au v8uavuas80 kolek@rambler.ru 999 v9awa ds " +
                "4645645cs dasha@ya.ru faawv 9993vf dd nick@gmail.com efawfe";

        /*
        группы - то, что заключаем в (), нумерация начинается с 1
        1   2   3
        ()  ()  ()
         */
        //1 группа   // 2 группа     // 3 группа
        Pattern email = Pattern.compile("([a-zA-z0-9]+)@([a-zA-Z0-9]+)\\.(com|ru)");
        Matcher matcher = email.matcher(text);

        while (matcher.find()) { // find() - ищет в тексте все совпадения по паттерну
            System.out.println(matcher.group(2)); // group() - собирает все совпадения
            // group(1) - выбирает только данные 1 группы, group(2) - второй
            // группы и т.д.
        }

    }
}

