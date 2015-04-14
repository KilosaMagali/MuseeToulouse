package museetoulouse

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(DemandeVisite)
class DemandeVisiteSpec extends Specification {

    void "test  DemandeVisite valide"(String unCode,int nombre, String unStatut, Date unDebut, Date uneFin) {
        given: "Une Demande de Visite initialisé correctement"

        DemandeVisite demandeVisite = new DemandeVisite(code: unCode, dateDebutPeriode: unDebut, dateFinPeriode: uneFin,
                nbPersonnes: nombre, statut: unStatut)

        expect: "la DemandeVisite est valide"
        demandeVisite.validate() == true

        where:
        unCode  |   nombre  |   unStatut                 |  unDebut    |   uneFin
        "0001"  | 4         |   "En cours de traitement" |  Mock(Date) |   Mock(Date)
        "OOO2"  | 5         |   "En cours de traitement" |  Mock(Date) |   Mock(Date)
        "0003"  | 1         |   "En cours de traitement" |  Mock(Date) |   Mock(Date)
    }

    void "test DemandeVisite non valide"(String unCode,int nombre, String unStatut, Date unDebut, Date uneFin) {
        given: "Une Demande de Visite initialisée de maniere incorrecte"

        DemandeVisite demandeVisite = new DemandeVisite(code: unCode, dateDebutPeriode: unDebut, dateFinPeriode: uneFin,
                nbPersonnes: nombre, statut: unStatut)

        expect: "DemandeVisite invalide"
        demandeVisite.validate() == false

        where:
        unCode  |   nombre  |   unStatut                    | unDebut       |uneFin
        "0001"  | 0         |   "En cours de traitement"    | Mock(Date) |   Mock(Date)
        2       | 7         |   "confirmé"                  | Mock(Date) |   Mock(Date)
        null    | 3         |   "En cours de traitement"    | Mock(Date) |   Mock(Date)
        "0001"  | 0         |   ""                          | Mock(Date) | Mock(Date)
    }
}
