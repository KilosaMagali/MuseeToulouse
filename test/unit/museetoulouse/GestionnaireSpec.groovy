package museetoulouse

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Gestionnaire)
class GestionnaireSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }


    @Unroll
    void "test la validite d'un gestionnaire"(String unNom) {
        given: "un gestionnaire initialise correctement"
        Gestionnaire gestionnaire = new Gestionnaire(nom: unNom)
        expect: "le gestionnaire est valide"
        gestionnaire.validate() == true
        and: "il n'a aucune musée"
        !gestionnaire.musees

        where:
        unNom = 'MonsieurLeGestionnaire'
    }

    @Unroll
    void "test l'invalidite d'un gestionnaire "(String unNom) {
        given: "un gestionnaire initialise de maniere incorrecte"
        Gestionnaire gestionnaire = new Gestionnaire(nom: unNom)
        expect: "le gestionnaire est invalide"
        gestionnaire.validate() == false
        where:
        unNom = ''
    }
    @Unroll
    void "test toString"() {
        given: "un gestionnaire"
        String nom = "Mairie de Toulouse - DGA Culture"
        Gestionnaire gestionnaire = new Gestionnaire(nom: nom)
        when: "on veut l'afficher"
        String toString = gestionnaire.toString()
        then: "le toString est bien affiche"
        toString == nom
    }
}
