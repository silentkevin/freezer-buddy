package net.sksi.freezerbuddy

class Freezer {
    List<ContainedItem> containedItems

    static hasMany = [
        containedItems: ContainedItem
    ]

    static constraints = {
    }
}
