package net.sksi.freezerbuddy

import grails.rest.Resource

@Resource(formats = ['hal', 'json', 'xml'])
class ItemDefinition {
    String id = UUID.randomUUID().toString()

    String singularName
    String pluralName
    String description

    String getPluralName() {
        return pluralName ?: singularName + 's'
    }

    static mapping = {
        id generator: 'assigned'
    }

    static constraints = {
        pluralName nullable: true
        description nullable: true, type: 'text'
    }
}
