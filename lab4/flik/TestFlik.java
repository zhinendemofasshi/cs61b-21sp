package flik;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestFlik {
    @Test
    public void TestCrashPoint() {
        for (int i = 0; i < 100000; i++) {
            int j = i;
            assertTrue(Flik.isSameNumber(i, j));
        }
    }
}
