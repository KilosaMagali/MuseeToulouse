package museetoulouse

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(DemandeVisiteMusee)
class DemandeVisiteMuseeSpec extends Specification {
    @Unroll
    void "test de validite d'une DemandeVisiteMusee "(Date dateDemandeVisite, def _) {
        given: "une demandeVisiteMusee est initialise avec une dateDemandeVisite, un musee et une demandeVisite"
        DemandeVisiteMusee demandeVisiteMusee = new DemandeVisiteMusee(
                dateDemandeVisite: dateDemandeVisite,
                musee: Mock(Musee),
                demandeVisite:  Mock(DemandeVisite))
        expect: "la DemandeVisiteMusee est valide"
        demandeVisiteMusee.validate()
        where:
        dateDemandeVisite | _
        new Date(2015,02,02) | _
    }
    @Unroll
    void "test d'invalidite d'une DemandeVisiteMuseet non valide"(Date dateDemandeVisite, Musee musee, DemandeVisite demandeVisite) {
        given: "une DemandeVisiteMusee initialise avec une dateDemandeVisite, un musee et une demandeVisite"
        DemandeVisiteMusee demandeVisiteMusee = new DemandeVisiteMusee(
                dateDemandeVisite: dateDemandeVisite,
                musee: musee,
                demandeVisite: demandeVisite)
        expect: "la DemandeVisiteMusee est non valide"
        !demandeVisiteMusee.validate()
        where:
        dateDemandeVisite | musee| demandeVisite
        null | Mock(Musee) | Mock(DemandeVisite)
    }
    @Unroll
    void "test toString"() {
        given: "une DemandeVisiteMusee"
        Date dateDemandeVisite = new Date(2015,02,02)
        DemandeVisiteMusee demandeVisiteMusee = new DemandeVisiteMusee(dateDemandeVisite: dateDemandeVisite)
        when: "on veut l'afficher"
        String toString = demandeVisiteMusee.toString()
        then: "le toString est bien affiche"
        toString == "$dateDemandeVisite $musee $demandeVisite"
    }

}
