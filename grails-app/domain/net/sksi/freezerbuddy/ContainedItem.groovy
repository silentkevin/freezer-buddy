package net.sksi.freezerbuddy

class ContainedItem {
    Long quantity = 0

    ItemDefinition itemDefinition

    static constraints = {
        quantity nullable: false
    }
}
