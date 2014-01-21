// Place your Spring DSL code here

import grails.rest.render.hal.HalJsonCollectionRenderer
import grails.rest.render.hal.HalJsonRenderer

import net.sksi.freezerbuddy.ContainedItem
import net.sksi.freezerbuddy.Freezer
import net.sksi.freezerbuddy.ItemDefinition

beans = {
    halJsonCollectionRendererContainedItem(HalJsonCollectionRenderer, ContainedItem)
    halJsonRendererContainedItem(HalJsonRenderer, ContainedItem)

    halJsonCollectionRendererFreezer(HalJsonCollectionRenderer, Freezer)
    halJsonRendererFreezer(HalJsonRenderer, Freezer)

    halJsonCollectionRendererItemDefinition(HalJsonCollectionRenderer, ItemDefinition)
    halJsonRendererItemDefinition(HalJsonRenderer, ItemDefinition)
}
