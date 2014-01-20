<%@ page import="net.sksi.freezerbuddy.ContainedItem" %>



<div class="fieldcontain ${hasErrors(bean: containedItemInstance, field: 'quantity', 'error')} required">
	<label for="quantity">
		<g:message code="containedItem.quantity.label" default="Quantity" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="quantity" type="number" value="${containedItemInstance.quantity}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: containedItemInstance, field: 'location', 'error')} ">
	<label for="location">
		<g:message code="containedItem.location.label" default="Location" />
		
	</label>
	<g:textField name="location" value="${containedItemInstance?.location}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: containedItemInstance, field: 'itemDefinition', 'error')} required">
	<label for="itemDefinition">
		<g:message code="containedItem.itemDefinition.label" default="Item Definition" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="itemDefinition" name="itemDefinition.id" from="${net.sksi.freezerbuddy.ItemDefinition.list()}" optionKey="id" required="" value="${containedItemInstance?.itemDefinition?.id}" class="many-to-one"/>
</div>

