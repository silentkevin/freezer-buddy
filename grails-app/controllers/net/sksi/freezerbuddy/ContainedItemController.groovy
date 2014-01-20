package net.sksi.freezerbuddy



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ContainedItemController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond ContainedItem.list(params), model:[containedItemInstanceCount: ContainedItem.count()]
    }

    def show(ContainedItem containedItemInstance) {
        respond containedItemInstance
    }

    def create() {
        respond new ContainedItem(params)
    }

    @Transactional
    def save(ContainedItem containedItemInstance) {
        if (containedItemInstance == null) {
            notFound()
            return
        }

        if (containedItemInstance.hasErrors()) {
            respond containedItemInstance.errors, view:'create'
            return
        }

        containedItemInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'containedItemInstance.label', default: 'ContainedItem'), containedItemInstance.id])
                redirect containedItemInstance
            }
            '*' { respond containedItemInstance, [status: CREATED] }
        }
    }

    def edit(ContainedItem containedItemInstance) {
        respond containedItemInstance
    }

    @Transactional
    def update(ContainedItem containedItemInstance) {
        if (containedItemInstance == null) {
            notFound()
            return
        }

        if (containedItemInstance.hasErrors()) {
            respond containedItemInstance.errors, view:'edit'
            return
        }

        containedItemInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'ContainedItem.label', default: 'ContainedItem'), containedItemInstance.id])
                redirect containedItemInstance
            }
            '*'{ respond containedItemInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(ContainedItem containedItemInstance) {

        if (containedItemInstance == null) {
            notFound()
            return
        }

        containedItemInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'ContainedItem.label', default: 'ContainedItem'), containedItemInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'containedItemInstance.label', default: 'ContainedItem'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
