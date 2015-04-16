package museetoulouse


import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class MuseePrefereController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]


    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond MuseePrefere.list(params), model: [museePrefereInstanceCount: MuseePrefere.count()]
    }


    def show(MuseePrefere museePrefereInstance) {
        respond museePrefereInstance
    }

    def create() {
        respond new MuseePrefere(params)
    }

    @Transactional
    def save(MuseePrefere museePrefereInstance) {
        if (museePrefereInstance == null) {
            notFound()
            return
        }

        if (museePrefereInstance.hasErrors()) {
            respond museePrefereInstance.errors, view: 'create'
            return
        }

        museePrefereInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'museePrefere.label', default: 'MuseePrefere'), museePrefereInstance.id])
                redirect museePrefereInstance
            }
            '*' { respond museePrefereInstance, [status: CREATED] }
        }
    }

    def edit(MuseePrefere museePrefereInstance) {
        respond museePrefereInstance
    }

    @Transactional
    def update(MuseePrefere museePrefereInstance) {
        if (museePrefereInstance == null) {
            notFound()
            return
        }

        if (museePrefereInstance.hasErrors()) {
            respond museePrefereInstance.errors, view: 'edit'
            return
        }

        museePrefereInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'MuseePrefere.label', default: 'MuseePrefere'), museePrefereInstance.id])
                redirect museePrefereInstance
            }
            '*' { respond museePrefereInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(MuseePrefere museePrefereInstance) {

        if (museePrefereInstance == null) {
            notFound()
            return
        }

        museePrefereInstance.delete flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'MuseePrefere.label', default: 'MuseePrefere'), museePrefereInstance.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }


            protected void notFound() {
                request.withFormat {
                    form multipartForm {

                        flash.message = message(code: 'default.not.found.message', args: [message(code: 'museePrefere.label', default: 'MuseePrefere'), params.id])
                        redirect action: "index", method: "GET"
                    }
                    '*' { render status: NOT_FOUND }
                }
            }
    def addToMesPreferes() {
        //println params.get("controller")
        MuseePrefere mesPreferes = session.getAttribute("mesPreferes")
        def museeInstanceList = params.previousSearchList
        println ("YEEEP"+museeInstanceList.size())
        if (!mesPreferes) {
            println ("Allocation!")
            mesPreferes = new MuseePrefere(idSession: session.getId())
            session["mesPreferes"] = mesPreferes
        }
        def musee = Musee.findByNom(params.get("nomMusee"))
        if((!mesPreferes.museePreferes) || (!mesPreferes.museePreferes*.nom.contains(musee.nom))) {
            mesPreferes.addToMuseePreferes(musee)
        }
        println (session.getId() + " : " + mesPreferes.museePreferes)
        redirect(controller: "musee", action: "doSearchMusee", params: [museeInstanceList : museeInstanceList])
    }

    def removeFromMesPreferes (){

        MuseePrefere mesPreferes= session.getAttribute("mesPreferes")
        if (!mesPreferes) {
            println ("Allocation!")
            mesPreferes = new MuseePrefere(idSession: session.getId())
            session["mesPreferes"] = mesPreferes
        }

        def musee
        def liste = mesPreferes.museePreferes.asList()*.nom
        for (int i = 0; i < liste.size(); i++) {
            if (liste.get(i).equals(params.get("nomMusee"))) {
                musee = mesPreferes.museePreferes.asList().get(i)
                break;
            }
        }
        mesPreferes.removeFromMuseePreferes(musee)
        println (session.getId() + " : " + mesPreferes.museePreferes)
        //if (mesPreferes.museePreferes.isEmpty()) {
            redirect(controller: "musee", action: "doSearchMusee")
        /*} else {
            redirect(controller: "musee", action: "doSearchMusee")
        }*/
    }
    def removeAllFromMesPreferes() {
        MuseePrefere mesPreferes= session.getAttribute("mesPreferes")
        mesPreferes.museePreferes.clear()
        redirect(controller: "musee", action: "doSearchMusee")
    }
}




