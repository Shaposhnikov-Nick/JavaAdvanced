package Maven.src.test.java;

import Maven.src.main.java.MyMath;
import org.junit.Test;

public class MyMathTest {

    // Проверяем, что при делении на 0 должен вывалиться ArithmeticException
    @Test(expected = ArithmeticException.class)
    public void zeroDenominatorShouldThrowZeroException() {
        MyMath.divide(1, 0);
    }
}
