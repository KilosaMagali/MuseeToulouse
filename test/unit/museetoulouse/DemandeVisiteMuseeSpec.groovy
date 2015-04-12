package museetoulouse

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(DemandeVisiteMusee)
class DemandeVisiteMuseeSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }


    @Unroll
    void "test une demande de visite musée valide"(Musee musee, DemandeVisite demandeDeVisite, Date date) {

        given: "une demande valide"
        DemandeVisiteMusee DemandeVisiteMusee = new DemandeVisiteMusee(musee: musee, demandeVisite: demandeDeVisite, dateDemande: date)

        expect: ""
        DemandeVisiteMusee.validate() == true

        where:
        musee       | demandeDeVisite          | date
        Mock(Musee) | Mock(DemandeVisite) | new Date()
    }

    @Unroll
    void "test une demande de visite musée invalide"(Musee musee, DemandeVisite demandeDeVisite, Date date) {
        given: "une demande invalide"
        DemandeVisiteMusee DemandeVisiteMusee = new DemandeVisiteMusee(musee: musee, demandeVisite: demandeDeVisite, dateDemande: date)

        expect: ""
        DemandeVisiteMusee.validate() == false

        where:
        musee       | demandeDeVisite        | date
        Mock(Musee) | Mock(DemandeVisite) | new Date() - 1
        Mock(Musee) | null                | new Date()
        null        | Mock(DemandeVisite) | new Date()
    }
}
