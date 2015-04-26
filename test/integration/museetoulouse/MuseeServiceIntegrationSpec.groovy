package museetoulouse



import spock.lang.*

/**
 *
 */
class MuseeServiceIntegrationSpec extends Specification {

    InitialiserDonneesService initialiserDonneesService
    MuseeService museeService;
    void "test insertion ou mise à jour d'un musee avec une adresse et un manager"() {
        given:"l'adresse"
        Adresse adresse = new Adresse(numero: 2, rue: "Rue des Archives", codePostal: "31500", ville: "Toulouse")
        and:"le gestionnaire"
        Gestionnaire gestionnaire = new Gestionnaire(nom: "Mairie de Toulouse - DGA Culture")
        and:"musee"
        Musee musee = new Musee(nom: "ARCHIVES MUNICIPALES TOULOUSE", horaireOuverture: "Ouvert du lundi au vendredi de 9h à 17h. Fermeture de 12h à 13h30 pendant toutes les vacances scolaires. Fermeture annuelle la dernière quinzaine de juillet.", telephone: "561616333", accesMetro: "Roseraie (A)", accesBus: "36, 38")
        when: "on tente de répercuter en base la création ou la modification du musee"
        Musee resultMuseum = museeService.insertOrUpdateMuseumForAddressAndManager(musee, adresse, gestionnaire)
        then: "le musee resultant pointe sur le musee initale"
        musee == resultMuseum
        and:"le musee résultante n'a pas d'erreur"
        !resultMuseum.hasErrors()
        and:"le musee résultante a un id"
        resultMuseum.id
        and:"le musee est bien presente en base"
        Musee.findById(resultMuseum.id) != null
        and: "le musee a pour adresse l'adresse passé en paramètre"
        resultMuseum.adresse == adresse
        and: "le musee a pour gestionnaire le gestionnaire passé en paramètre"
        resultMuseum.gestionnaire == gestionnaire
    }
    void "test insertion ou mise à jour d'un musee avec une adresse"() {
        given:"adresse"
        Adresse adresse = new Adresse(numero: 2, rue: "Rue des Archives", codePostal: "31500", ville: "Toulouse")
        and:"gestionnaire"
        Gestionnaire gestionnaire = new Gestionnaire(nom: "Mairie de Toulouse - DGA Culture").save()
        and:"musee"
        Musee musee = new Musee(nom: "ARCHIVES MUNICIPALES TOULOUSE", horaireOuverture: "Ouvert du lundi au vendredi de 9h à 17h. Fermeture de 12h à 13h30 pendant toutes les vacances scolaires. Fermeture annuelle la dernière quinzaine de juillet.", telephone: "561616333", accesMetro: "Roseraie (A)", accesBus: "36, 38")
        musee.setGestionnaire(gestionnaire)
        when: "on tente de répercuter en base la création ou la modification du musee"
        Musee resultMuseum = museeService.insertOrUpdateMuseumForAddress(musee, adresse)
        then: "le musee resultant pointe sur le musee initale"
        musee == resultMuseum
        and:"le musee résultante n'a pas d'erreur"
        !resultMuseum.hasErrors()
        and:"le musee résultante a un id"
        resultMuseum.id
        and:"le musee est bien presente en base"
        Musee.findById(resultMuseum.id) != null
        and: "le musee a pour adresse l'adresse passé en paramètre"
        resultMuseum.adresse == adresse
    }
    void "test insertion ou mise à jour d'un musee avec un gestionnaire"() {
        given:"gestionnaire"
        Gestionnaire manager = new Gestionnaire(nom: "Mairie de Toulouse - DGA Culture")
        and:"address"
        Adresse address = new Adresse(numero: 2, rue: "Rue des Archives", codePostal: "31500", ville: "Toulouse").save()
        and:"musee"
        Musee museum = new Musee(nom: "ARCHIVES MUNICIPALES TOULOUSE", horaireOuverture: "Ouvert du lundi au vendredi de 9h à 17h. Fermeture de 12h à 13h30 pendant toutes les vacances scolaires. Fermeture annuelle la dernière quinzaine de juillet.", telephone: "561616333", accesMetro: "Roseraie (A)", accesBus: "36, 38")
        museum.setAdresse(address)
        when: "on tente de répercuter en base la création ou la modification du musee"
        Musee resultMuseum = museeService.insertOrUpdateMusee(museum, manager)
        then: "le musee resultant pointe sur le musee initale"
        museum == resultMuseum
        and:"le musee résultante n'a pas d'erreur"
        !resultMuseum.hasErrors()
        and:"le musee résultante a un id"
        resultMuseum.id
        and:"le musee est bien presente en base"
        Musee.findById(resultMuseum.id) != null
        and: "le musee a pour manager le manager passé en paramètre"
        resultMuseum.gestionnaire== manager
    }
    void "test de recherche sur les musees"() {
        given: "les museums fournis par le jeu de test "
        initialiserDonneesService
        when: "on cherche les museums dont le titre du musee contient 'compagnons'"
        List<Musee> res = museeService.searchMusee("compagnons", null,null,null)
        then: "on récupère uniquement un museum"
        res.size() == 1
        res*.nom.contains("MUSEE DES COMPAGNONS")
        when: "on cherche les museums dont la rue du musee contient 'archives'"
        res = museeService.searchMusee("", "archives", "",)
        then: "on récupère uniquement un museum"
        res.size() == 1
        res*.nom.contains("ARCHIVES MUNICIPALES TOULOUSE")
        when: "on cherche les museums dont le code postal du musee est '31300"
        res = museeService.searchMusee("", "", "31300")
        then: "on récupère uniquement un musee"
        res.size() == 2
        res*.nom.contains("MUSEE DE L'HISTOIRE DE LA MEDECINE DE TOULOUSE")
        res*.nom.contains("MUSEE DES INSTRUMENTS DE MEDECINE DES HOPITAUX DE TOULOUSE")
        when:"on cherche les museums dont le titre du museum contient 'not_today'"
        res = museeService.searchMusee("never_again", "", "")
        then: "on ne récupère aucun musee"
        res.size() == 0
        when:"on positionne tous les critères à null"
        res = museeService.searchMusee("", "", "")
        then: "on récupère tous les musees"
        res.size() == 12
    }
}
