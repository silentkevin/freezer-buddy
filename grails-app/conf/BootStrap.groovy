import net.sksi.freezerbuddy.ContainedItem
import net.sksi.freezerbuddy.Freezer
import net.sksi.freezerbuddy.ItemDefinition

class BootStrap {

    def init = { servletContext ->
        if (Freezer.list().size() == 0) {
            ItemDefinition id1 = new ItemDefinition(singularName: "Angus Burger", description: "Angus cheeseburger").save()
            ItemDefinition id2 = new ItemDefinition(singularName: "Cioppino", pluralName: "Cioppino", description: "Cioppino").save()
            ItemDefinition id3 = new ItemDefinition(singularName: "Random Seafood", description: "Random seafood").save()
            ItemDefinition id4 = new ItemDefinition(singularName: "Pecan Pie Slice", description: "Pecan pie slice").save()

            Freezer freezer = new Freezer(location: "Basement", description: "Haier chest freezer")

            ContainedItem ci1 = new ContainedItem(itemDefinition: id1, quantity: 2, freezer: freezer)
            ContainedItem ci2 = new ContainedItem(itemDefinition: id2, quantity: 1, freezer: freezer)
            ContainedItem ci3 = new ContainedItem(itemDefinition: id3, quantity: 1, freezer: freezer, location: 'top')
            ContainedItem ci4 = new ContainedItem(itemDefinition: id4, quantity: 3, freezer: freezer)

            freezer.addToContainedItems(ci1)
            freezer.addToContainedItems(ci2)
            freezer.addToContainedItems(ci3)
            freezer.addToContainedItems(ci4)

            freezer.save(flush: true)
        }
    }

    def destroy = {
    }
}
