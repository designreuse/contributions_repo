<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 
      <div class="col-md-3 col-sm-6">       
   <div class="box"> 
      <div class="box-header">
                  <h3 class="box-title">Classes</h3>
         </div>
     <div class="box-body no-padding">  
    <c:if test="${not empty classes}">
	 <div class='spacer'></div>
	 <div class="bodycontainer scrollable" style="max-height: 300px; width: 100%;">
	<table class="table table-striped table-hover table-bordered" >
	<c:forEach items="${classes}" var="classes">
	 <tr>
	  <td><a onclick="editClass(${classes.claCode});" href="#">${classes.claDescn}</a></td>
	  </tr>
	 </c:forEach>
	</table>
	</div>
	</c:if>
	</div>
	</div>
	</div>
                    
              <div class="col-md-9 col-sm-6">
              
                 <div class="nav-tabs-custom">
                      <ul class="nav nav-tabs">
                          <li class="active"><a href="#classformdiv" role="tab" data-toggle="tab">Classes</a></li>
                          <li id="subcldetails" style="display:none;"><a href="#subclassdet" role="tab" data-toggle="tab">Sub Classes</a></li>
                       </ul>
                     
                        
                       
                        <div class="tab-content" style="height: 400px;">
                             
                               <div class="tab-pane active" id="classformdiv">
		                      <%@ include file="classform.jsp" %>
		                      
		                     </div>
		                     
                              
			                  <div class="tab-pane" id="subclassdet">
			                       
			                       <%@ include file="classsubclasses.jsp" %>
			                  </div>
                 
                        </div> <!-- tab-content --> 
                       </div>
              </div> 

  
  <jsp:include page="modals/subclassModal.jsp"></jsp:include>
 
 <script src="<c:url value='/resources/js/pages/classes.js' />"></script>