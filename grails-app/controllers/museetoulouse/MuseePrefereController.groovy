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
}
