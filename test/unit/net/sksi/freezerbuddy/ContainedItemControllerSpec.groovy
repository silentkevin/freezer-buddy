package net.sksi.freezerbuddy



import grails.test.mixin.*
import spock.lang.*

@TestFor(ContainedItemController)
@Mock(ContainedItem)
class ContainedItemControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.containedItemInstanceList
            model.containedItemInstanceCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.containedItemInstance!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            def containedItem = new ContainedItem()
            containedItem.validate()
            controller.save(containedItem)

        then:"The create view is rendered again with the correct model"
            model.containedItemInstance!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            containedItem = new ContainedItem(params)

            controller.save(containedItem)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/containedItem/show/1'
            controller.flash.message != null
            ContainedItem.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def containedItem = new ContainedItem(params)
            controller.show(containedItem)

        then:"A model is populated containing the domain instance"
            model.containedItemInstance == containedItem
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def containedItem = new ContainedItem(params)
            controller.edit(containedItem)

        then:"A model is populated containing the domain instance"
            model.containedItemInstance == containedItem
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/containedItem/index'
            flash.message != null


        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def containedItem = new ContainedItem()
            containedItem.validate()
            controller.update(containedItem)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.containedItemInstance == containedItem

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            containedItem = new ContainedItem(params).save(flush: true)
            controller.update(containedItem)

        then:"A redirect is issues to the show action"
            response.redirectedUrl == "/containedItem/show/$containedItem.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/containedItem/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def containedItem = new ContainedItem(params).save(flush: true)

        then:"It exists"
            ContainedItem.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(containedItem)

        then:"The instance is deleted"
            ContainedItem.count() == 0
            response.redirectedUrl == '/containedItem/index'
            flash.message != null
    }
}
