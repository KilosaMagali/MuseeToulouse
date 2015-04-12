package museetoulouse

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(DemandeVisiteMusee)
class DemandeVisiteMuseeSpec extends Specification {
    //A tester dans test d'integration
    /*@Unroll
    void "test une demande de visite musée valide"(Date uneDate) {
        given: "une demandeVisiteMusee est initialisée de manière valide"
        DemandeVisiteMusee demandeVisiteMusee = new DemandeVisiteMusee(dateDemandeVisite: uneDate)
        Musee musee = Mock(Musee)
        DemandeVisite demandeVisite = Mock(DemandeVisite)
        musee.addToDemandesVisite(demandeVisiteMusee)
        demandeVisite.addToMusees(demandeVisiteMusee)
        expect: "La demandeVisiteMusee est valide"
        demandeVisiteMusee.validate() == true
        where:
        uneDate = Mock(Date)
    }

    @Unroll
    void "test une demande de visite musée invalide"(Date uneDate) {
        given: "une demande est initialisée de manière invalide"
        DemandeVisiteMusee demandeVisiteMusee = new DemandeVisiteMusee(dateDemandeVisite: uneDate)
        expect: "La demandeVisiteMusee est valide"
        demandeVisiteMusee.validate() == false
        where:
        uneDate = null

    }*/

}
