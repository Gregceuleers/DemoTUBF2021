package be.bxlformation.tu.assertions;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestInfoDemo {

    @BeforeEach
    void setUp(TestInfo testInfo, TestReporter testReporter) {
        String displayName = testInfo.getDisplayName();
        assertTrue(displayName.equals("TEST 1") || displayName.equals("test2()"));
        testReporter.publishEntry(displayName);
    }

    @Test
    @DisplayName("TEST 1")
    void test1(TestInfo testInfo) {
        assertEquals("TEST 1", testInfo.getDisplayName());
    }

    @Test
    void test2() {

    }

}
