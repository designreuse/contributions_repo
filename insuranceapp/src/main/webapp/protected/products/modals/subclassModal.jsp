<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<form:form id="proSubclass" commandName="productSubclass" method="post" action="createProductSubclass">
 <table class="table table-striped table-hover table-bordered">
			<thead>
				<tr>
				   <th width="1%"><input type="checkbox" name="Select All" id="select_all" onclick="selectAllSubclasses();"/></th>
					<th width="4%">Code</th>
					<th width="12%">Sub Class</th>
				</tr>
			</thead>
			<tbody>
			  
			    <c:forEach items="${prosubclasses}" var="subclass">
			    <tr>
			       <td ><form:checkbox path="selectedSubclass" class="selected_data" value="${subclass.sclCode}"/></td>
			        <td><c:out value="${subclass.sclShtDesc}" /></td>
			        <td><c:out value="${subclass.sclDesc}" /></td>
			     </tr>
			    </c:forEach>
           </tbody>
</table>
 <form:hidden path="proCode" id="subclassProCode"/>
</form:form>