<%@ page import="net.sksi.freezerbuddy.Freezer" %>



<div class="fieldcontain ${hasErrors(bean: freezerInstance, field: 'location', 'error')} ">
	<label for="location">
		<g:message code="freezer.location.label" default="Location" />
		
	</label>
	<g:textField name="location" value="${freezerInstance?.location}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: freezerInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="freezer.description.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${freezerInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: freezerInstance, field: 'notes', 'error')} ">
	<label for="notes">
		<g:message code="freezer.notes.label" default="Notes" />
		
	</label>
	<g:textField name="notes" value="${freezerInstance?.notes}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: freezerInstance, field: 'containedItems', 'error')} ">
	<label for="containedItems">
		<g:message code="freezer.containedItems.label" default="Contained Items" />
		
	</label>
	<g:select name="containedItems" from="${net.sksi.freezerbuddy.ContainedItem.list()}" multiple="multiple" optionKey="id" size="5" value="${freezerInstance?.containedItems*.id}" class="many-to-many"/>
</div>

