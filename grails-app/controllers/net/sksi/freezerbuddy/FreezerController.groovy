package net.sksi.freezerbuddy

import grails.converters.JSON
import grails.converters.XML
import grails.transaction.Transactional


import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.NO_CONTENT
import static org.springframework.http.HttpStatus.OK

@Transactional(readOnly = true)
class FreezerController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        List<Freezer> list = Freezer.list(params)
        withFormat {
            html {
                respond list, model:[freezerInstanceCount: Freezer.count()]
            }
            json {
                respond list as JSON
            }
            xml {
                respond list as XML
            }
        }
    }

    def show(Freezer freezerInstance) {
        respond freezerInstance
    }

    def create() {
        respond new Freezer(params)
    }

    @Transactional
    def save(Freezer freezerInstance) {
        if (freezerInstance == null) {
            notFound()
            return
        }

        if (freezerInstance.hasErrors()) {
            respond freezerInstance.errors, view:'create'
            return
        }

        freezerInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'freezerInstance.label', default: 'Freezer'), freezerInstance.id])
                redirect freezerInstance
            }
            '*' { respond freezerInstance, [status: CREATED] }
        }
    }

    def edit(Freezer freezerInstance) {
        respond freezerInstance
    }

    @Transactional
    def update(Freezer freezerInstance) {
        if (freezerInstance == null) {
            notFound()
            return
        }

        if (freezerInstance.hasErrors()) {
            respond freezerInstance.errors, view:'edit'
            return
        }

        freezerInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Freezer.label', default: 'Freezer'), freezerInstance.id])
                redirect freezerInstance
            }
            '*'{ respond freezerInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Freezer freezerInstance) {

        if (freezerInstance == null) {
            notFound()
            return
        }

        freezerInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Freezer.label', default: 'Freezer'), freezerInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'freezerInstance.label', default: 'Freezer'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
