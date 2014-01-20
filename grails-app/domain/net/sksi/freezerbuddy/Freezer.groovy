package net.sksi.freezerbuddy

class Freezer {
    List<ContainedItem> containedItems

    static hasMany = [
        ContainedItem: 'containedItems'
    ]

    static constraints = {
    }
}
