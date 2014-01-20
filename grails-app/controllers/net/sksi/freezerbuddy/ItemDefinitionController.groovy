package net.sksi.freezerbuddy



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ItemDefinitionController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond ItemDefinition.list(params), model:[itemDefinitionInstanceCount: ItemDefinition.count()]
    }

    def show(ItemDefinition itemDefinitionInstance) {
        respond itemDefinitionInstance
    }

    def create() {
        respond new ItemDefinition(params)
    }

    @Transactional
    def save(ItemDefinition itemDefinitionInstance) {
        if (itemDefinitionInstance == null) {
            notFound()
            return
        }

        if (itemDefinitionInstance.hasErrors()) {
            respond itemDefinitionInstance.errors, view:'create'
            return
        }

        itemDefinitionInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'itemDefinitionInstance.label', default: 'ItemDefinition'), itemDefinitionInstance.id])
                redirect itemDefinitionInstance
            }
            '*' { respond itemDefinitionInstance, [status: CREATED] }
        }
    }

    def edit(ItemDefinition itemDefinitionInstance) {
        respond itemDefinitionInstance
    }

    @Transactional
    def update(ItemDefinition itemDefinitionInstance) {
        if (itemDefinitionInstance == null) {
            notFound()
            return
        }

        if (itemDefinitionInstance.hasErrors()) {
            respond itemDefinitionInstance.errors, view:'edit'
            return
        }

        itemDefinitionInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'ItemDefinition.label', default: 'ItemDefinition'), itemDefinitionInstance.id])
                redirect itemDefinitionInstance
            }
            '*'{ respond itemDefinitionInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(ItemDefinition itemDefinitionInstance) {

        if (itemDefinitionInstance == null) {
            notFound()
            return
        }

        itemDefinitionInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'ItemDefinition.label', default: 'ItemDefinition'), itemDefinitionInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'itemDefinitionInstance.label', default: 'ItemDefinition'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
