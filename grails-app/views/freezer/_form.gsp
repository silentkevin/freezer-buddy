<%@ page import="net.sksi.freezerbuddy.Freezer" %>



<div class="fieldcontain ${hasErrors(bean: freezerInstance, field: 'containedItems', 'error')} ">
	<label for="containedItems">
		<g:message code="freezer.containedItems.label" default="Contained Items" />
		
	</label>
	<g:select name="containedItems" from="${net.sksi.freezerbuddy.ContainedItem.list()}" multiple="multiple" optionKey="id" size="5" value="${freezerInstance?.containedItems*.id}" class="many-to-many"/>
</div>

