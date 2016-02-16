
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <form:form id="prodSubclassForm" class="form-horizontal" role="form" commandName="proSubclass" method="post"
    action="updateProductSubclass">
		  <div class="form-group">
		    <label class="control-label col-sm-4" for="subclassName">Sub Class</label>
		    <div class="col-sm-8">
		       <p class="form-control-static"> <c:out value="${proSubclass.subclassName}"></c:out>  </p>
		     
		    </div>
		  </div>
		  
		  <div class="form-group  required">
		    <label class="control-label col-sm-4" for="clpMandatory">Mandatory</label>
		    <div class="col-sm-8">
		       <form:select path="clpMandatory" class="form-control">
                  <form:option value="N">No</form:option>
                  <form:option value="Y">Yes</form:option>
		       </form:select>
		    </div>
		  </div>
		  
		  <div class="form-group  required">
		    <label class="control-label col-sm-4" for="clpWef">WEF</label>
		    <div class="col-sm-8">
		      <form:input path="clpWef" class="form-control datepicker" placeholder="DD-MM-YYYY"/>
		    </div>
		  </div>
		  
		   <div class="form-group">
		    <label class="control-label col-sm-4" for="clpWet">WET</label>
		    <div class="col-sm-8">
		      <form:input path="clpWet" class="form-control datepicker" placeholder="DD-MM-YYYY"/>
		    </div>
		  </div>
		  
		  <form:hidden path="clpCode"/>
		  <form:hidden path="proCode"/>
		  <form:hidden path="sclCode"/>
 </form:form>
