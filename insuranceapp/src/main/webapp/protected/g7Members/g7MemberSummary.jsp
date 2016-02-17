<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <div class='spacer'></div>
  <label class="control-label col-sm-4" for="subclassName">Member Name</label>
  <p class="form-control-static"> <c:out value="${currMember.fullName}"></c:out>  </p>
  <label class="control-label col-sm-4" for="subclassName">Member Telephone</label>
  <p class="form-control-static"> <c:out value="${currMember.gmemTel}"></c:out>  </p>
  <label class="control-label col-sm-4" for="subclassName">Member Email</label>
  <p class="form-control-static"> <c:out value="${currMember.gmemEmail}"></c:out>  </p>
  <label class="control-label col-sm-4" for="subclassName">Registration Date</label>
  <p class="form-control-static"> <c:out value="${currMember.gmemRegisterDate}"></c:out>  </p>
  <label class="control-label col-sm-4" for="subclassName">Member Active</label>
  <p class="form-control-static"> <c:out value="${currMember.gmemActiveDecoded}"></c:out>  </p>
