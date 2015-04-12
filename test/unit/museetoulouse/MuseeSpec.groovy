package museetoulouse

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Musee)
class MuseeSpec extends Specification {
    @Unroll
    void "test la validité d'un musée "(String nom, String horairesOuverture, String telephone,
                             String accesBus, String accesMetro, def _) {
        given: "Un musée initialisé correctement"
        Musee musee = new Musee(nom: nom, horaireOuverture: horairesOuverture, telephone: telephone,
                accesBus: accesBus, accesMetro: accesMetro,
                adresse: Mock(Adresse), gestionnaire: Mock(Gestionnaire))
        expect: "le musée est valide"
        musee.validate() == true
        where:
        nom | horairesOuverture | telephone | accesBus | accesMetro | _
        "musée" | "08h30 à 16h" | "0714083898" | "Bus 34" | "ligne B" | _
        "musée" | "08h30 à 16h" | "0714083898" | "Bus 34" | "tram" | _
        "musée" | "08h30 à 16h" | "0714083898" | null | "ligne A" | _
        "musée" | "08h30 à 16h" | "0714083898" | null | null | _
        "musée" | "08h30 à 16h" | "0714083898" | "ligne A" | null | _
    }
    @Unroll
    void "test  l'invalidité d'un musée"(String nom, String horairesOuverture, String telephone,
                               String accesBus, String accesMetro, def _){
        given: "Un musée initialisé avec des infos invalide"
        Musee musee = new Musee(nom: nom, horairesOUvertures: horairesOuverture,
                telephone: telephone, accesBus: accesBus, accesMetro: accesMetro,
                adresse: Mock(Adresse), gestionnaire: Mock(Gestionnaire))
        expect:"le musée est invalide"
        musee.validate() == false
        where:
        nom | horairesOuverture | telephone | accesBus | accesMetro | _
        null | "08h30 à 16h" | "0714083898" | "Bus 34" | "ligne B" | _
        "" | null | "0714083898" | "Bus 34" | "ligne B" | _
        "musée" | "08h30 à 16h" | "" | "Bus 34" | "ligne B" | _
        "nom" | "" | "0714083898" | "Bus 34" | "ligne B" | _
        "" | "" | "" | "" | "" | _
    }

}
