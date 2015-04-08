package museetoulouse

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Adresse)
class AdresseSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    @Unroll
    void "test la validite d'une adresse"(String unNumero, String uneRue, String unCode, String uneVille) {

        given: "une adresse initialise correctement"
        Adresse adresse = new Adresse(numero: unNumero, rue: uneRue, codePostal: unCode, ville: uneVille)

        expect: "l'adresse est valide"
        adresse.validate() == true


        where:
        unNumero    | uneRue  | unCode     | uneVille
        "60" | "bellefontaine"  | "31100" | "Toulouse"
        "45" | "Rue de Gambetta"  | "31000" | "Toulouse"
        "07" | "Route de Narbonne"  | "31000" | "Toulouse"

    }

    @Unroll
    void "test l'invalidite d'une adresse"(String unNumero, String uneRue, String unCode, String uneVille) {

        given: "une adresse initialise de manière incorrecte"
        Adresse adresse = new Adresse(numero: unNumero, rue: uneRue, codePostal: unCode, ville: uneVille)

        expect: "l'adresse n'est pas valide"
        adresse.validate() == false


        where:
        unNumero    | uneRue  | unCode     | uneVille
        "60" | "bellefontaine"  | "" | "Toulouse"
        "45" | "Rue de Gambetta"  | "31000" | ""
        "07" | "Route de Narbonne"  | "31000" | null

    }
}
