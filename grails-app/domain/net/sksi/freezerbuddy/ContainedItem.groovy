package net.sksi.freezerbuddy

class ContainedItem {
    String id = UUID.randomUUID().toString()

    Long quantity = 0

    String location

    ItemDefinition itemDefinition

    static mapping = {
        id generator: 'assigned'
    }

    static constraints = {
        quantity nullable: false
        location nullable: true
    }

    @Override
    String toString() {
        return "$quantity ${quantity != 1 ? itemDefinition.pluralName : itemDefinition.singularName}"
    }
}
