
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
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

    @Test
    public void TestCheckKeyExists() {
        assertTrue(rep.checkKeyExists(1));
    }

    @Test
    public void TestGetValue() {
        assertEquals("a", rep.getValue(1));
    }
}
