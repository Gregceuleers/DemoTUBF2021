package be.bxlformation.tu;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Première classe de tests")
//@DisplayNameGeneration(DisplayNameGenerator.Standard.class)
public class PremierTest {

    /**
     * Vérification d'une addition de 2 nbres entiers
     * - Les 2 nombres doivent être entiers
     * - Aucun des 2 nombres ne sont null
     * - Que le résultat de 2 nombres corresponde au résultat souhaité
     */

    // ETAPE D'IMPLEMENTATION D'UN TEST
    // Arrange - Act - Assert

    // Arrange : initialiser tous les entrants nécessaire
    // Act : execution du test avec les entrants et souvegarde des sortants
    // Assert : validez les sortants en fonction de ce qui est attendu
    //          avec vos entrants


    @Test
    @DisplayName("Ceci est mon premier test sur la validité de l'addition")
    void premierTestSucces() {
        // ARRANGE
        int a = 3, b = 4;
        Calculation premierTest = new Calculation();

        // ACT
        int resultat = premierTest.addition(a,b);

        // ASSERT
        assertEquals(resultat, 7);
    }

    @Test
    void premierTestFailCarPasDesEntiers() {
        // Arrange
        String inputUtilisateur_a = "3", inputUtilisateur_b = "4";
        int resultat;
        NumberFormatException e = null;

        // Act

        try {
            resultat = Integer.parseInt(inputUtilisateur_a);
            resultat = Integer.parseInt(inputUtilisateur_b);
        } catch (NumberFormatException exc) {
                e = exc;
        }

        // Assert
        assertNull(e);
    }


    @Test

    void nom_de_test_autogenere() {


    }
}
