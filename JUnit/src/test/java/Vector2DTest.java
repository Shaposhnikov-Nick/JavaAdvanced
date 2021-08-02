import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Vector2DTest {
    private final double EPS = 1e-9; // дельта, на которую могут различаться ожидаемый и фактический результаты
    private static Vector2D v1;

    // создается окружение для тестирования
    // @Before - Объект v1 будет создаватся перед каждым тестовым методом
    @BeforeClass // -  Объект v1 будет создаватся один раз для всего класса (должен быть статический)
    public static void createNewVector(){
        v1 = new Vector2D();
    }

    @Test
    public void newVectorShouldHaveZeroLength(){
        Assert.assertEquals(0,v1.length(),EPS); // 0 - expected, v1.length - actual, 1e-9 - delta
                                                               // 1e-9 = 0,0000000001
    }

    @Test
    public void newVectorShouldHaveZeroX(){
        Assert.assertEquals(0,v1.getX(), EPS);
    }

    @Test
    public void newVectorShouldHaveZeroY(){
        Assert.assertEquals(0,v1.getY(), EPS);
    }
}
