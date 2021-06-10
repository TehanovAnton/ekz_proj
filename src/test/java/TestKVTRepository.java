import com.example.classes.KeyValue.KVTRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestKVTRepository {
    KVTRepository rep;

    @Before
    public void init() {
        rep = new KVTRepository();
        System.out.println("ready:start");
    }
    @After
    public void end() {
        System.out.println("end");
    }

    @Test(timeout=100)
    public void TestCheckKeyExists() {
        assertTrue(rep.checkKeyExists(1));
    }

    @Test(timeout=100)
    public void TestGetValue() {
        assertNotEquals("", rep.getValue(1));
    }
}
