package Annotations;

public class Test {
    @MethodInfo(author = "Nick", dateOfCreation = 2021, purpose = "Print Hello World")
    public void print() {
        System.out.println("Hello world");
    }

    @MethodInfo(purpose = "Print Goodbye")
    public void print2() {
        System.out.println("Goodbye");
    }
}
