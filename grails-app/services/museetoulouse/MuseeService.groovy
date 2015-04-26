package museetoulouse

import grails.transaction.Transactional

@Transactional
class MuseeService {

    DemandeVisite getDemandeVisite(String code){
        if(code != null)
            code = code.trim()
        return DemandeVisite.findByCode(code)
    }

    Musee insertOrUpdateMusee(Musee unMusee, Gestionnaire unGestionnaire) {
        unMusee.setGestionnaire(unGestionnaire)
        unGestionnaire.save()
        unMusee.save()
        unMusee
    }

    void deleteMusee(Musee unMusee) {
        unMusee.gestionnaire.removeFromMusees(unMusee)
        unMusee.delete()
    }
    Musee insertOrUpdateMuseumForAddressAndManager(Musee musee, Adresse adresse, Gestionnaire gestionnaire) {
        musee.setAdresse(adresse)
        musee.setGestionnaire(gestionnaire)
        adresse.save()
        gestionnaire.save()
        musee.save()
    }

    Musee insertOrUpdateMuseumForAddress(Musee musee, Adresse adresse) {
        musee.setAdresse(adresse)
        adresse.save()
        musee.save()
    }
    List<Musee> searchMusee(String nomMusee, String codePostal, String uneRue,def params) {
        def criteria = Musee.createCriteria()
        def res = criteria.list (max:params.max,offset:params.offset){
            if (nomMusee) {
                like 'nom', "%${nomMusee}%"
            }
            if (codePostal) {
                adresse {
                    eq 'adresse.codePostal', codePostal
                }
            }
            if (uneRue) {
                adresse {
                    like 'adresse.rue', "%${uneRue}%"
                }
            }
        }
        res
    }
}