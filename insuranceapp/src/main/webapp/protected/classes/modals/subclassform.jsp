
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <form:form id="prodSubclassForm" class="form-horizontal" role="form" commandName="subclassCommand" method="post"
    action="createSubclass">
    
          <div class="form-group required">
		    <label class="control-label col-sm-4" for="sclShtDesc">Sub Class Id</label>
		    <div class="col-sm-8">
		       <form:input path="sclShtDesc" class="form-control" placeholder="Enter Subclass Id"/>
		     
		    </div>
		  </div>
		  
		  <div class="form-group required">
		    <label class="control-label col-sm-4" for="sclDesc">Sub Class</label>
		    <div class="col-sm-8">
		        <form:input path="sclDesc" class="form-control" placeholder="Enter Subclass"/>
		    </div>
		  </div>
		  
		  <div class="form-group">
		    <label class="control-label col-sm-4" for="sclPolicyPrefix">Policy Prefix</label>
		    <div class="col-sm-8">
		        <form:input path="sclPolicyPrefix" class="form-control" placeholder="Enter Policy Prefix"/>
		    </div>
		  </div>
		  
		  <div class="form-group">
		    <label class="control-label col-sm-4" for="sclClaimPrefix">Claim Prefix</label>
		    <div class="col-sm-8">
		        <form:input path="sclClaimPrefix" class="form-control" placeholder="Enter Claim Prefix"/>
		    </div>
		  </div>
		  
		  
		  <div class="form-group required">
		    <label class="control-label col-sm-4" for="sclWef">WEF</label>
		    <div class="col-sm-8">
		      <form:input path="sclWef" class="form-control datepicker" placeholder="DD-MM-YYYY"/>
		    </div>
		  </div>
		  
		   <div class="form-group">
		    <label class="control-label col-sm-4" for="sclWet">WET</label>
		    <div class="col-sm-8">
		      <form:input path="sclWet" class="form-control datepicker" placeholder="DD-MM-YYYY"/>
		    </div>
		  </div>
		  
		  <form:hidden path="claCode"/>
		  <form:hidden path="sclCode"/>
 </form:form>
