package museetoulouse


import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class DemandeVisiteController {

    MuseeService museeService
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    def searchDemande() {
        params.max = 5
        def demandeList = museeService.getDemandeVisite(params.code)
        render(view: 'rechercheDemande', model: [demandeVisiteInstanceList: demandeList, demandeVisiteInstanceCount: 1])
        //[museeInstanceList:museeList, museeInstanceCount: museeList.size()]
    }

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond DemandeVisite.list(params), model: [demandeVisiteInstanceCount: DemandeVisite.count()]
    }

    def show(DemandeVisite demandeVisiteInstance) {
        respond demandeVisiteInstance
    }

    def create() {
        respond new DemandeVisite(params)
    }

    @Transactional
    def save(DemandeVisite demandeVisiteInstance) {
        if (demandeVisiteInstance == null) {
            notFound()
            return
        }

        if (demandeVisiteInstance.hasErrors()) {
            respond demandeVisiteInstance.errors, view: 'create'
            return
        }

        demandeVisiteInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'demandeVisite.label', default: 'DemandeVisite'), demandeVisiteInstance.id])
                redirect demandeVisiteInstance
            }
            '*' { respond demandeVisiteInstance, [status: CREATED] }
        }
    }

    def edit(DemandeVisite demandeVisiteInstance) {
        respond demandeVisiteInstance
    }

    @Transactional
    def update(DemandeVisite demandeVisiteInstance) {
        if (demandeVisiteInstance == null) {
            notFound()
            return
        }

        if (demandeVisiteInstance.hasErrors()) {
            respond demandeVisiteInstance.errors, view: 'edit'
            return
        }

        demandeVisiteInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'DemandeVisite.label', default: 'DemandeVisite'), demandeVisiteInstance.id])
                redirect demandeVisiteInstance
            }
            '*' { respond demandeVisiteInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(DemandeVisite demandeVisiteInstance) {

        if (demandeVisiteInstance == null) {
            notFound()
            return
        }

        demandeVisiteInstance.delete flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'DemandeVisite.label', default: 'DemandeVisite'), demandeVisiteInstance.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'demandeVisite.label', default: 'DemandeVisite'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}