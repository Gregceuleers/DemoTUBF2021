package be.bxlformation.tu.assertions;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.logging.Logger;

public class DemoRepetition {

    private Logger logger = Logger.getLogger(DemoRepetition.class.getName());

    @BeforeEach
    void beforeEach(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        logger.info(String.format("Répétition %d / %d pour %s",
                repetitionInfo.getCurrentRepetition(),
                repetitionInfo.getTotalRepetitions(),
                testInfo.getTestMethod().get().getName()));
    }

    @RepeatedTest(7)
    void repeatTest() {

    }
    @RepeatedTest(3)
    void repeatedTestWithRepetitionInfo(RepetitionInfo repetitionInfo) {
        assertEquals(3, repetitionInfo.getTotalRepetitions());
    }

    @RepeatedTest(value = 3, name = "{displayName} {currentRepetition}/{totalRepetitions}")
    @DisplayName("Action répétée !")
    void customDisplay(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        assertEquals("Action répétée ! " + repetitionInfo.getCurrentRepetition() + "/3", testInfo.getDisplayName());
    }

}
