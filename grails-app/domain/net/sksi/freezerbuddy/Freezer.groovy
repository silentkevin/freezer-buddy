package net.sksi.freezerbuddy

import grails.rest.Resource

@Resource(uri = '/freezer', formats = ['json', 'xml'])
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
