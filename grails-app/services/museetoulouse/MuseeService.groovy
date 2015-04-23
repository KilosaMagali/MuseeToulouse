package museetoulouse

import grails.transaction.Transactional

@Transactional
class MuseeService {


    Musee insertOrUpdateMusee(Musee unMusee, Gestionnaire unGestionnaire) {
        unGestionnaire.addToMusees(unMusee).save()
        unMusee
    }

    void deleteMusee(Musee unMusee) {
        unMusee.gestionnaire.removeFromMusees(unMusee)
        unMusee.delete()
    }
    List<Musee> searchMusee(String nomMusee, String codePostal, String uneRue,def params) {
        def criteria = Musee.createCriteria()
        List<Musee> res = criteria.list(max:params.max,offset:params.offset) {
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