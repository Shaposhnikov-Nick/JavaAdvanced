package LambdaExpressions;

interface Executable {
    int execute(int x, int y);
}

class Runner {
    void run(Executable e) {
        int a = e.execute(10, 20);
        System.out.println(a);
    }
}

/*
class ExecutableImplementation implements Executable{

    @Override
    public void execute() {
        System.out.println("Hello!");
    }
}
 */

public class lambdaTest {
    public static void main(String[] args) {
        Runner runner = new Runner();
        int a = 1;


        // 1 способ - создание объекта нового класса, имплементирующего интерфейс
        // runner.run(new ExecutableImplementation());

        // 2 способ - создание анонимного класса
        runner.run(new Executable() {
            @Override
            public int execute(int x, int y) {
                return x + y;
            }
        });


        // 3 способ - лямбда-выражения
        runner.run((x,y) -> x + y + a);


    }
}
