package be.bxlformation.tu.exercices;

 /*
    Un  programme  prend  en  entrée  trois  entiers.  Ces  trois  entiers  sont
interprétés comme représentant les longueurs des cotés d’un triangle.
Le programme rend un résultat précisant s’il s’agit d’un triangle scalène,
isocèle ou équilatéral.
     */

import be.bxlformation.tu.interfaces.TestLifeCycleLogger;
import org.junit.jupiter.api.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TriangleTests implements TestLifeCycleLogger {

    private final TriangleBF triangle = new TriangleBF();

    @BeforeEach
    void beforeEachTest() {
        triangle.setA(3);
        triangle.setB(4);
        triangle.setC(6);
    }

    @Nested
    class TestsEchecDeValidationDuTriangle {

        @Test
        void uneValeurVautZeroTest_A() {
            triangle.setA(0);

            TriangleBFException exception = assertThrows(TriangleBFException.class,
                    () -> triangle.checkValidity(
                            triangle.getA(),
                            triangle.getB(),
                            triangle.getC())
            );
            assertEquals("Un des 3 côtés vaut 0", exception.getMessage());
        }

        @Test
        void uneValeurVautZeroTest_B() {
            triangle.setB(0);

            TriangleBFException exception = assertThrows(TriangleBFException.class,
                    () -> triangle.checkValidity(
                            triangle.getA(),
                            triangle.getB(),
                            triangle.getC())
            );
            assertEquals("Un des 3 côtés vaut 0", exception.getMessage());
        }

        @Test
        void uneValeurVautZeroTest_C() {
            triangle.setC(0);

            TriangleBFException exception = assertThrows(TriangleBFException.class,
                    () -> triangle.checkValidity(
                            triangle.getA(),
                            triangle.getB(),
                            triangle.getC())
            );
            assertEquals("Un des 3 côtés vaut 0", exception.getMessage());
        }

        @Test
        void uneValeurEstNegativeTest_A() {
            triangle.setA(-3);

            TriangleBFException exception = assertThrows(TriangleBFException.class,
                    () -> triangle.checkValidity(
                            triangle.getA(),
                            triangle.getB(),
                            triangle.getC())
            );
            assertEquals("Un des côtés est négatif", exception.getMessage());

        }

        @Test
        void uneValeurEstNegativeTest_B() {
            triangle.setB(-3);

            TriangleBFException exception = assertThrows(TriangleBFException.class,
                    () -> triangle.checkValidity(
                            triangle.getA(),
                            triangle.getB(),
                            triangle.getC())
            );
            assertEquals("Un des côtés est négatif", exception.getMessage());

        }

        @Test
        void uneValeurEstNegativeTest_C() {
            triangle.setC(-3);

            TriangleBFException exception = assertThrows(TriangleBFException.class,
                    () -> triangle.checkValidity(
                            triangle.getA(),
                            triangle.getB(),
                            triangle.getC())
            );
            assertEquals("Un des côtés est négatif", exception.getMessage());

        }

        @Test
        void sommeDe_Aet_BEstInferieurOuEgalA_C() {
            assertAll("sommeCotes_C",
                    () -> {
                        triangle.setC(7);

                        TriangleBFException exception = assertThrows(TriangleBFException.class,
                                () -> triangle.checkValidity(
                                        triangle.getA(),
                                        triangle.getB(),
                                        triangle.getC())
                        );
                        assertEquals("La somme de deux côtés vaut le troisième", exception.getMessage());

                    },
                    () -> {
                        triangle.setC(9);

                        TriangleBFException exception = assertThrows(TriangleBFException.class,
                                () -> triangle.checkValidity(
                                        triangle.getA(),
                                        triangle.getB(),
                                        triangle.getC())
                        );
                        assertEquals("La somme de deux côtés est inférieure au troisième", exception.getMessage());

                    }
            );
        }

        @Test
        void sommeDe_Aet_CEstInferieurOuEgalA_B() {
            assertAll("sommeCotes_B",
                    () -> {
                        triangle.setB(9);

                        TriangleBFException exception = assertThrows(TriangleBFException.class,
                                () -> triangle.checkValidity(
                                        triangle.getA(),
                                        triangle.getB(),
                                        triangle.getC())
                        );
                        assertEquals("La somme de deux côtés vaut le troisième", exception.getMessage());

                    },
                    () -> {
                        triangle.setB(12);

                        TriangleBFException exception = assertThrows(TriangleBFException.class,
                                () -> triangle.checkValidity(
                                        triangle.getA(),
                                        triangle.getB(),
                                        triangle.getC())
                        );
                        assertEquals("La somme de deux côtés est inférieure au troisième", exception.getMessage());

                    }
            );
        }

        @Test
        void sommeDe_Bet_CEstInferieurOuEgalA_A() {
            assertAll("sommeCotes",
                    () -> {
                        triangle.setA(10);

                        TriangleBFException exception = assertThrows(TriangleBFException.class,
                                () -> triangle.checkValidity(
                                        triangle.getA(),
                                        triangle.getB(),
                                        triangle.getC())
                        );
                        assertEquals("La somme de deux côtés vaut le troisième", exception.getMessage());

                    },
                    () -> {
                        triangle.setA(12);

                        TriangleBFException exception = assertThrows(TriangleBFException.class,
                                () -> triangle.checkValidity(
                                        triangle.getA(),
                                        triangle.getB(),
                                        triangle.getC())
                        );
                        assertEquals("La somme de deux côtés est inférieure au troisième", exception.getMessage());

                    }
            );
        }

        @Test
        void triangleDoitContenir3ProprietesDeTypeInt() {
            Field[] fields = TriangleBF.class.getDeclaredFields();

            assertEquals(3, fields.length);

            assertAll("proprieteTypeInt",
                    () -> assertEquals(int.class, fields[0].getType()),
                    () -> assertEquals(int.class, fields[1].getType()),
                    () -> assertEquals(int.class, fields[2].getType())
            );
        }

        @Test
        void checkValidityDoitAvoir3ParametresDeTypeInt() {
            Method[] methods = TriangleBF.class.getDeclaredMethods();
            Method method = Stream.of(methods).filter(m -> m.getName().equals("checkValidity")).findFirst().orElse(null);

            assertNotNull(method);

            assertEquals(3, method.getParameterCount());

            Parameter[] parameters = method.getParameters();
            assertAll("paramètresTypeInt",
                    () -> assertEquals(int.class, parameters[0].getType()),
                    () -> assertEquals(int.class, parameters[1].getType()),
                    () -> assertEquals(int.class, parameters[2].getType())
            );
            
        }
    }

    @Nested
    class TestsSuccesValidationTriangle {

        @Test
        void TriangleEstEquilateral() throws TriangleBFException {
            triangle.setB(3);
            triangle.setC(3);

            assertEquals("équilatéral", triangle.checkValidity(
                    triangle.getA(),
                    triangle.getB(),
                    triangle.getC()
            ));
        }

        @Test
        void TriangleEstIsoceleDeBase_A() throws TriangleBFException {
            triangle.setB(6);

            assertEquals("isocèle", triangle.checkValidity(
                    triangle.getA(),
                    triangle.getB(),
                    triangle.getC()
            ));
        }

        @Test
        void TriangleEstIsoceleDeBase_B() throws TriangleBFException {
            triangle.setA(6);

            assertEquals("isocèle", triangle.checkValidity(
                    triangle.getA(),
                    triangle.getB(),
                    triangle.getC()
            ));
        }

        @Test
        void TriangleEstIsoceleDeBase_C() throws TriangleBFException {
            triangle.setA(4);

            assertEquals("isocèle", triangle.checkValidity(
                    triangle.getA(),
                    triangle.getB(),
                    triangle.getC()
            ));
        }

        @Test
        void TriangleEstScalene() throws TriangleBFException {

            assertEquals("scalène", triangle.checkValidity(
                    triangle.getA(),
                    triangle.getB(),
                    triangle.getC()
            ));
        }

    }

}
