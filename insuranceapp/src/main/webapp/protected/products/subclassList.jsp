<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>

 <div class='spacer'></div>
 <a href="<c:url value="/protected/classes"/>" class="btn btn-primary"> 
    Create Sub Class
 </a>
 <input type="button" class="btn btn-primary" value="Select Sub Class" onclick="showSubclassDialog()">
  <div class='spacer'></div>
<div id="dialog" title="Confirmation Required" style="display: none;">
  Are you sure you want to delete this subclass?
</div>
 <div class="bodycontainer scrollable" style="max-height: 300px; width: 100%;">​
 <table class="table table-striped table-hover table-bordered">
			<thead>
				<tr>
					<th width="4%">Code</th>
					<th width="18%">Sub Class</th>
					<th width="12%">Mandatory</th>
					<th width="12%">WEF</th>
					<th width="12%">WET</th>
					<th width="10%"></th>
				</tr>
			</thead>
			<tbody>
			    <c:forEach items="${subclasses}" var="subclass">
			       <tr>  
			        <td><c:out value="${subclass[4]}" /></td>
			        <td><c:out value="${subclass[5]}" /></td>
			        <td><c:out value="${subclass[1]}" /></td>
			        <td><fmt:formatDate value="${subclass[2]}" pattern="dd/MM/yyyy" /></td>
			        <td><fmt:formatDate value="${subclass[3]}" pattern="dd/MM/yyyy" /></td>
			        <td>
			         <a href="#" class="btn btn-primary" onclick="editProductSubclass(${subclass[0]});">
			           <i class="fa fa-pencil"></i>
			          </a>
			          <a href="#" class="btn btn-primary" onclick="deleteProdSubclass(${subclass[0]});"
			          >
			           <i class="fa fa-times"></i>
			          </a>
			        </td>
			       </tr>
			    </c:forEach>
             
			</tbody>
</table>
</div>
