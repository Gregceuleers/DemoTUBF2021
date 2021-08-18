package be.bxlformation.tu.interfaces;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestInterfaceDemo implements TestLifeCycleLogger {

    @Test
    void estIdentique() {
        assertEquals(1, 1, "EST TJS EGAL");
    }
}
