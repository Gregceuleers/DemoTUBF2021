package be.bxlformation.tu.assertions;

import be.bxlformation.tu.Calculation;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class DemoAssertions {

    private final Calculation calculation = new Calculation();

    private final Person p = new Person("Ceuleers","Greg");

    @Test
    void standardAssertions() {
        assertEquals(2, calculation.addition(1,1));
        assertEquals(2, calculation.addition(1,1), "1 + 2 ne fait pas 2 !!!");
        assertTrue(1 < 2, "La condition retourne FAUX");
    }

    @Test
    void exceptionTesting() {
        Calculation calculation1 = null;
        NullPointerException exception = assertThrows(
                NullPointerException.class,
                () -> calculation1.addition(1,1));
    }

    @Test
    void divisionParZeroTest() {
        Calculation calculation = new Calculation();
        ArithmeticException exception = assertThrows(
                ArithmeticException.class,
                () -> calculation.divide(5,0)
                );
        assertEquals("division par zéro", exception.getMessage());
    }

    @Disabled
    @Test
    void timeoutNotExceeded() {
       String result = assertTimeout(Duration.ofMillis(100), DemoAssertions::nawak);
       assertEquals("nawak", result);
       
    }

    private static String nawak() throws InterruptedException {
        Thread.sleep(300);
        return "nawak";
    }

    @Test
    void testPerson() {
        assertAll("person",
                () -> assertEquals("Ceuleers", p.getLast_name()),
                () -> assertEquals("Greg", p.getFirst_name())
        );

    }

    @Test
    void dependantAssertions() {
        assertAll("properties",
                () -> {
                    assertNotNull(p.getFirst_name());
                    assertAll("first_name",
                            () -> assertTrue(p.getFirst_name().startsWith("G"), "Problème début du prénom"),
                            () -> assertTrue(p.getFirst_name().endsWith("g"), "PB FIN PRENOM")
                            );
                },
                () -> {
                    assertNotNull(p.getLast_name());
                    assertAll("last_name",
                            () ->assertTrue(p.getLast_name().contains("eu"))
                            );
                }
                );
    }
    @Target({ElementType.METHOD, ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Test
    @EnabledOnOs(OS.WINDOWS)
    @interface TestOnWindows {}

   @TestOnWindows
    void OSTests() {


    }

    @Test
    @EnabledForJreRange( min = JRE.JAVA_8, max = JRE.JAVA_12)
    @EnabledOnJre(JRE.JAVA_8)
    void onlyONJava8() {

    }

    @Test
    @EnabledIfSystemProperty(named = "os.arch", matches = ".*64.*")
    void onlyOn64BitsArchitcture() {

    }

    @Test
    @EnabledIf("conditionPersonnalisee")
    void enabledByCondition() {

    }

    @Test
    @DisabledIf("conditionPersonnalisee")
    void disabledBYCondition() {

    }

    boolean conditionPersonnalisee() {
        return true;
    }

}
