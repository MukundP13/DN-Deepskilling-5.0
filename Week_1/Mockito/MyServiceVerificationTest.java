import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;

public class MyServiceVerificationTest {

    @Test
    public void testVerifyInteraction() {
        ExternalApi mockApi = mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        service.fetchData();

        verify(mockApi, times(1)).getData();
    }
}