<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <div class='spacer'></div>
<table class="table table-striped table-hover table-bordered">
<c:forEach items="${g7Mems}" var="g7Member" varStatus="itr">
 <tr>
  <td><a onclick="initializeMemberDetails(${g7Member.gmemCode});" href="#">${g7Member.gmemOtherNames} &nbsp; ${g7Member.gmemSurname}</a></td>
  </tr>
 </c:forEach>
</table>
