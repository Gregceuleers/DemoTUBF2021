package be.bxlformation.tu;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledIf;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Exercices {

    /*
    Un  programme  prend  en  entrée  trois  entiers.  Ces  trois  entiers  sont
interprétés comme représentant les longueurs des cotés d’un triangle.
Le programme rend un résultat précisant s’il s’agit d’un triangle scalène,
isocèle ou équilatéral.
     */

    private final Triangle triangle = new Triangle();

    @BeforeAll
    void setUp() {
        triangle.setA(3);
        triangle.setB(4);
        triangle.setC(6);
    }

    @Nested
    class EchecDeValidationDuTriangle {

        @Test
        void uneValeurVautZeroTest() {

                triangle.setA(0);

                TriangleException exception = assertThrows(TriangleException.class, () -> triangle.createTriangle(triangle.getA(), triangle.getB(), triangle.getC()));
                assertEquals("Un des côtés vaut 0", exception.getMessage());
        }

        @Test()
        void uneValeurEstNegativeTest() {

            triangle.setA(-3);

            TriangleException exception = assertThrows(TriangleException.class, () -> triangle.createTriangle(triangle.getA(), triangle.getB(), triangle.getC()));
            assertEquals("Un des côté à une longueur négative", exception.getMessage());

        }

        @Test
        void sommeDeDeuxValeursVautLaTroisiemeTest() {

            triangle.setA(2);
            triangle.setB(3);
            triangle.setC(5);

            TriangleException exception = assertThrows(TriangleException.class, () -> triangle.createTriangle(triangle.getA(), triangle.getB(), triangle.getC()));
            assertEquals("La somme de 2 côtés vaut le troisième côté", exception.getMessage());


        }

        @Test
        void sommeDeDeuxValeursEstInferieurALaTroisiemeTest() {

            triangle.setA(2);
            triangle.setB(3);
            triangle.setC(6);

            TriangleException exception = assertThrows(TriangleException.class, () -> triangle.createTriangle(triangle.getA(), triangle.getB(), triangle.getC()));
            assertEquals("La somme de 2 côtés est inférieure au troisième côté", exception.getMessage());

        }

        /*
         *  1.  Scalène valide
         */
        @Test
        void scaleneValideTest() {

        }
    }
}
