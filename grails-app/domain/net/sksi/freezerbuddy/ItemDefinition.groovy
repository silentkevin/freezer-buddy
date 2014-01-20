package net.sksi.freezerbuddy

class ItemDefinition {
    String id = UUID.randomUUID().toString()

    String name
    String description

    static mapping = {
        id generator: 'assigned'
    }

    static constraints = {
        description nullable: true, type: 'text'
    }
}
