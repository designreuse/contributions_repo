<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>

 <div class='spacer'></div>
 <input type="button"  class="btn btn-primary" onclick="newSubclassDialog();" value="New Sub Class" >
 <div class='spacer'></div>
 <div id="dialog" title="Confirmation Required" style="display: none;">
  Are you sure you want to delete this subclass?
</div>
<div class="bodycontainer scrollable" style="max-height: 300px; width: 100%;">
 <table class="table table-striped table-hover table-bordered">
			<thead>
				<tr>
					<th width="4%">Code</th>
					<th width="25%">Sub Class</th>
					<th width="10%">WEF</th>
					<th width="10%">WET</th>
					<th width="10%">Claim Prefix</th>
					<th width="10%">Policy Prefix</th>
					<th width="5%"></th>
					<th width="5%"></th>
				</tr>
			</thead>
	
			<tbody>
			    <c:forEach items="${subclasses}" var="subclass">
			       <tr>  
			        <td><c:out value="${subclass.sclShtDesc}" /></td>
			        <td><c:out value="${subclass.sclDesc}" /></td>
			        <td><fmt:formatDate value="${subclass.sclWef}" pattern="dd/MM/yyyy" /></td>
			        <td><fmt:formatDate value="${subclass.sclWet}" pattern="dd/MM/yyyy" /></td>
			        <td><c:out value="${subclass.sclClaimPrefix}" /></td>
			        <td><c:out value="${subclass.sclPolicyPrefix}" /></td>
			        <td>
			         <a href="#" class="btn btn-primary" onclick="editSubclassDialog(${subclass.sclCode});">
			           <i class="fa fa-pencil"></i>
			          </a>
			          </td>
			          <td>
			          <a href="#" class="btn btn-primary"
			          onclick="deleteSubclass(${subclass.sclCode});">
			           <i class="fa fa-times"></i>
			          </a>
			        </td>
			       </tr>
			    </c:forEach>
             
			</tbody>
</table>
</div>