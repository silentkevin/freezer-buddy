import groovy.transform.TypeChecked
import net.sksi.freezerbuddy.ContainedItem
import net.sksi.freezerbuddy.Freezer
import net.sksi.freezerbuddy.ItemDefinition

@TypeChecked
class BootStrap {

    def init = { servletContext ->
        if (Freezer.list().size() == 0) {
            ItemDefinition id1 = new ItemDefinition(name: "Angus Burgers", description: "Angus cheeseburgers")
            ItemDefinition id2 = new ItemDefinition(name: "Cioppino", description: "Cioppino")
            ItemDefinition id3 = new ItemDefinition(name: "Random Seafood", description: "Random seafood")
            ItemDefinition id4 = new ItemDefinition(name: "Pecan Pie", description: "Pecan pie")

            ContainedItem cd1 = new ContainedItem(itemDefinition: id1, quantity: 2)
            ContainedItem cd2 = new ContainedItem(itemDefinition: id2, quantity: 1)
            ContainedItem cd3 = new ContainedItem(itemDefinition: id3, quantity: 1)
            ContainedItem cd4 = new ContainedItem(itemDefinition: id4, quantity: 3)

            Freezer freezer = new Freezer()
        }
    }

    def destroy = {
    }
}
