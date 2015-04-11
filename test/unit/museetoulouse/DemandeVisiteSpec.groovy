package museetoulouse

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(DemandeVisite)
class DemandeVisiteSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test DemandeVisite valide"() {
        given: "Une Demande de Visite"

        DemandeVisite demandeVisite = new DemandeVisite(code: unCode, dateDebut: unDebut, dateFin: uneFin,
                nombreVisiteurs: nombre, statut: unStatut)

        expect: "la DemandeVisite est valide"
        demandeVisite.validate() == true

        where:
        unCode  |   nombre  |   unStatut   | unDebut                 |uneFin
        1       | 4         |   "Attente"  |new Date(1972, 6, 17)    |new Date(1972, 6, 17)
        2       | 5         |   "confirmé"  | new Date(1972, 6, 17)   |new Date(1972, 6, 17)
        3       | 1         |   "Annuler"  | new Date(1972, 6, 17)   |new Date(1972, 6, 17)
    }

    void "test DemandeVisite non valide"() {
        given: "Une Demande de Visite"

        DemandeVisite demandeVisite = new DemandeVisite(code: unCode, dateDebut: unDebut, dateFin: uneFin,
                nombreVisiteurs: nombre, statut: unStatut)

        expect: "Validation"
        demandeVisite.validate() == false

        where:
        unCode  |   nombre  |   unStatut   | unDebut                 |uneFin
        1       | 0         |   ''         |new Date(1972, 6, 17)    |new Date(1972, 6, 17)
        2       | 7        |   "confirmé"  | new Date(1972, 6, 17)   |new Date(1972, 6, 17)
    }
}
