package museetoulouse



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class DemandeVisiteMuseeController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond DemandeVisiteMusee.list(params), model: [demandeVisiteMuseeInstanceCount: DemandeVisiteMusee.count()]
    }
    def renderPageSaisirDemandeVisite() {
        render(view: 'saisirDemandeVisite')
    }
     def justCreatedDemandeVisiteMusee() {
         MuseePrefere mesPreferes = session.getAttribute("mesPreferes")
         if (!mesPreferes) {
             println ("Allocation!")
             mesPreferes = new MuseePrefere(idSession: session.getId())
             session["mesPreferes"] = mesPreferes
         }
         Date dateDebut = params.datedebut
         Date dateFin = params.datefin
         int nbPersonnes = params.int('nbpersonnes')
         print("NOOW"+dateDebut+" "+dateFin+" "+ nbPersonnes+"Oh yeah")
         String unStatut = "En cours de traitement"
         String unCode = "CODE"+""+nbPersonnes+""+mesPreferes.museePreferes.size()
         DemandeVisite demandeVisite = new DemandeVisite(code: unCode, dateDebutPeriode: dateDebut, dateFinPeriode: dateFin,
                 nbPersonnes: nbPersonnes, statut: unStatut)
         if(!demandeVisite.validate()) {
             demandeVisite.errors.allErrors.each {
                 println it
             }
         }
         DemandeVisiteMusee demandeVisiteMusee = new DemandeVisiteMusee(dateDemandeVisite: new Date())
         demandeVisiteMusee.setDemandeVisite(demandeVisite)
         //demandeVisiteMusee.setMusee(mesPreferes.museePreferes.getAt(0))
         int sizePref = mesPreferes.museePreferes.size()
         for (int i=0; i<sizePref; i++) {
             demandeVisiteMusee.setMusee(mesPreferes.museePreferes.getAt(i))
         }
         demandeVisiteMusee.demandeVisite.addToMusees(demandeVisiteMusee)
         demandeVisiteMusee.musee.addToDemandesVisite(demandeVisiteMusee)
         demandeVisite.save()
         demandeVisiteMusee.save()
         println ("Demande de visite enregistrée, ton code est" + unCode)
         render(view: "demandeVisiteEnregistree", model: [codeDemande: unCode, nbPersonnes: nbPersonnes,dateDebut : dateDebut, dateFin : dateFin])
     }

    def show(DemandeVisiteMusee demandeVisiteMuseeInstance) {
        respond demandeVisiteMuseeInstance
    }

    def create() {
        respond new DemandeVisiteMusee(params)
    }

    @Transactional
    def save(DemandeVisiteMusee demandeVisiteMuseeInstance) {
        if (demandeVisiteMuseeInstance == null) {
            notFound()
            return
        }

        if (demandeVisiteMuseeInstance.hasErrors()) {
            respond demandeVisiteMuseeInstance.errors, view: 'create'
            return
        }

        demandeVisiteMuseeInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'demandeVisiteMusee.label', default: 'DemandeVisiteMusee'), demandeVisiteMuseeInstance.id])
                redirect demandeVisiteMuseeInstance
            }
            '*' { respond demandeVisiteMuseeInstance, [status: CREATED] }
        }
    }

    def edit(DemandeVisiteMusee demandeVisiteMuseeInstance) {
        respond demandeVisiteMuseeInstance
    }

    @Transactional
    def update(DemandeVisiteMusee demandeVisiteMuseeInstance) {
        if (demandeVisiteMuseeInstance == null) {
            notFound()
            return
        }

        if (demandeVisiteMuseeInstance.hasErrors()) {
            respond demandeVisiteMuseeInstance.errors, view: 'edit'
            return
        }

        demandeVisiteMuseeInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'DemandeVisiteMusee.label', default: 'DemandeVisiteMusee'), demandeVisiteMuseeInstance.id])
                redirect demandeVisiteMuseeInstance
            }
            '*' { respond demandeVisiteMuseeInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(DemandeVisiteMusee demandeVisiteMuseeInstance) {

        if (demandeVisiteMuseeInstance == null) {
            notFound()
            return
        }

        demandeVisiteMuseeInstance.delete flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'DemandeVisiteMusee.label', default: 'DemandeVisiteMusee'), demandeVisiteMuseeInstance.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'demandeVisiteMusee.label', default: 'DemandeVisiteMusee'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
