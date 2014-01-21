package net.sksi.freezerbuddy

import grails.rest.Resource

@Resource(formats = ['hal', 'json', 'xml'])
class Freezer {
    String id = UUID.randomUUID().toString()

    String location
    String description
    String notes

    List<ContainedItem> containedItems

    static hasMany = [
        containedItems: ContainedItem
    ]

    static mapping = {
        id generator: 'assigned'
        description type: 'text'
        notes type: 'text'
        containedItems fetch: 'eager'
    }

    static constraints = {
        location nullable: false
        description nullable: true
        notes nullable: true
    }

    @Override
    String toString() {
        "Freezer located at ${location} with ${containedItems.size()} kinds of items in it"
    }
}
