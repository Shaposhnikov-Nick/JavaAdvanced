import org.junit.Test;

public class NetworkUtilsTest {

    // Проверяем, что метод должен выполнится быстрее чем за 1 с
    @Test(timeout = 1000)
    public void getConnectionShouldReturnFasterThanOneSecond(){
        NetworkUtils.getConnections();
    }
}
