<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

 <form:form class="form-horizontal" role="form" commandName="classCommand"
                       method="post" action="createClass" id="classForm">
                         <h1>Classes Details</h1>
                         
                         <c:if test="${not empty message}">
                          <div id="errorArea"  class="alert alert-success alert-dismissible" role="alert">
		                      <button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
		                      <div id="message">
		                        <c:out value="${message}"></c:out>
		                      </div>
                          </div>
                          </c:if>
                          
                        
                         <div class="form-group"> 
				        <div class="col-md-10">
				         <input type="button" onclick="newClasses();" class="btn btn-primary" id="btnNewClass" value="New" >
				         <input type="submit" class="btn btn-primary" id="btnSaveClass" value="Save" >
				         </div>
				         </div>
				         
				         
                         
                         <div class="form-group required">
						    <label class="control-label col-sm-2" for="claDescn">Description</label>
						    <div class="col-sm-6">
						      <form:input path="claDescn" class="form-control"  placeholder="Enter Class Description"/>
						    </div>
						    <form:errors path="claDescn" cssStyle="color: #ff0000;" cssClass="col-sm-4"></form:errors>
						  </div>
						  
						  <div class="form-group required">
						    <label class="control-label col-sm-2" for="claWef">WEF</label>
						    <div class="col-sm-6">
						      <form:input path="claWef"  class="form-control datepicker" placeholder="DD-MM-YYYY"/>
						    </div>
						    <form:errors path="claWef" cssStyle="color: #ff0000;" cssClass="col-sm-4"></form:errors>
						  </div>
						  
						   <div class="form-group">
						    <label class="control-label col-sm-2" for="claWet">WET</label>
						    <div class="col-sm-6">
						      <form:input path="claWet"  class="form-control datepicker" placeholder="DD-MM-YYYY"/>
						    </div>
						  </div>
						  <form:hidden path="claCode" id="claPk"/>
                       
                     </form:form>