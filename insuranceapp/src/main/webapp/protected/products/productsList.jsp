<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${not empty products}">
 <input type="button" onclick="clearForm();" value="New Product" class="btn btn-primary">
 <div class='spacer'></div>
<table class="table table-striped table-hover table-bordered">
<c:forEach items="${products}" var="product" varStatus="itr">
 <tr>
  <td><a onclick="editProduct(${product.proCode});" href="#">${product.proDesc}</a></td>
  </tr>
 </c:forEach>
</table>

</c:if>