package be.bxlformation.tu.interfaces;

import org.junit.jupiter.api.*;

import java.util.logging.Logger;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public interface TestLifeCycleLogger {

    Logger logger = Logger.getLogger(TestLifeCycleLogger.class.getName());

    @BeforeAll
    default void beforeAllTests() {
        logger.info("Début des tests");
    }

    @AfterAll
    default void afterAllTests() {
        logger.info("fin des tests");
    }

    @BeforeEach
    default void beforeEachTest(TestInfo testInfo) {
        logger.info(() -> String.format("A propos de l'execution [%s]", testInfo.getDisplayName()));
    }

    @AfterEach
    default void afterEachTest(TestInfo testInfo) {
        logger.info(() -> String.format("Fin de l'execution [%s]", testInfo.getDisplayName()));
    }
}
