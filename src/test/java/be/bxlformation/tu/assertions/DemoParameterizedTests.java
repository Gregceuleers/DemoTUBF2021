package be.bxlformation.tu.assertions;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.EnumSet;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class DemoParameterizedTests {

    enum JourSemaine {
        LUNDI,
        MARDI,
        MERCREDI,
        JEUDI,
        VENDREDI,
        SAMEDI,
        DIMANCHE
    }

    @ParameterizedTest
    @ValueSource(strings = {"lundi", "mardi", "mercredi", "jeudi", "vendredi","samedi","dimanche"})
    void estPresentDansEnum(String jour) {
       assertNotNull(JourSemaine.valueOf(jour.toUpperCase()));
    }

    @ParameterizedTest
    @EnumSource(JourSemaine.class)
    void estPresent(JourSemaine jour) {
        assertNotNull(jour);
    }

    @ParameterizedTest
    @EnumSource(names = {"LUNDI", "JEUDI"})
    void estInclusDansEnum(JourSemaine jour) {
        assertTrue(EnumSet.of(JourSemaine.LUNDI, JourSemaine.JEUDI).contains(jour));
    }

    @ParameterizedTest
    @MethodSource("fournisseur")
    void estInjecteParUneMethode(String argument) {
        assertTrue(argument.endsWith("e"));
    }

    static Stream<String> fournisseur() {
        return Stream.of("pomme", "poire", "banane");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/semaine.csv")
    void testAvecFichierCSV(String jour, int index) {
        assertNotNull(jour);
        assertNotEquals(0, index);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/semaine.csv")
    void testAvecFichierCSVWithObjet(ArgumentsAccessor argumentsAccessor) {
        Jour j = new Jour();
        j.setName(argumentsAccessor.getString(0));
        j.setIndex(argumentsAccessor.getInteger(1));
        assertNotNull(j.getName());
        assertNotEquals(0, j.getIndex());
    }

    static class Jour {
        private String name;
        private int index;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }
    }
}
