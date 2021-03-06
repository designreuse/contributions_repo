<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form:form class="form-horizontal" role="form" modelAttribute="organization"
                       method="post" action="createOrganization" id="orgForm"
                       enctype="multipart/form-data">
                   <div class="box-body">
				          <div class="spacer"></div>
				        <a href="<c:url value='/protected/organization/editOrganization'/> " class="btn btn-primary">Edit</a>
				        <hr>
				        <div class="form-group">
				            <div class="col-md-6">
		                    <label for="orgName" class="control-label col-md-5">Organization Name</label>
		                     <div class="col-md-7">
		                         <p class="form-control-static"> <c:out value="${organization.orgName}"></c:out></p>
		                     </div>               
		                    </div>
		                    <div class="col-md-6">
		                    <label for="orgShtDesc" class="control-label col-md-5">Alias</label>
		                    <div class="col-md-7">
		                      <p class="form-control-static"> <c:out value="${organization.orgShtDesc}"></c:out></p>
		                    </div>    
		                    </div>   
				        </div>
				     
				        <div class="form-group">
				          <div class="col-md-6">
		                    <label for="orgMobile" class="control-label col-md-5">Mobile</label>
		                     <div class="col-md-7"> 
		                     <p class="form-control-static"> <c:out value="${organization.orgMobile}"></c:out></p>               
		                 </div>
		                 </div>
		                 <div class="col-md-6">
		                  <label for="orgPhone" class="control-label col-xs-5">Phone</label>
		                    <div class="col-md-7"> 
		                     <p class="form-control-static"> <c:out value="${organization.orgPhone}"></c:out></p>                  
		                 </div>
		                 </div>
				        </div>
				       
				        
				          <div class="form-group">
				           <div class="col-md-6">
		                    <label for="orgFax" class="control-label col-md-5">Fax Number</label>
		                    <div class="col-md-7">
		                     <p class="form-control-static"> <c:out value="${organization.orgFax}"></c:out></p>                  
		                 </div>
		                 </div>
		                  <div class="col-md-6">
		                 <label for="orgWebsite" class="control-label col-md-5">WebSite</label>
		                    <div class="col-md-7">
		                      <p class="form-control-static"> <c:out value="${organization.orgWebsite}"></c:out></p>                   
		                    </div>
		                 </div>
				        </div>
				        
				        <div class="form-group">
				           <div class="col-md-6">
		                    <label for="orgDesc" class="control-label col-md-5">Org. Description</label>
		                    <div class="col-md-7">
		                     <p class="form-control-static"> <c:out value="${organization.orgDesc}"></c:out></p>                  
		                 </div>
		                 </div>
		                 <div class="col-md-6">
		                 
		                 </div>
		                 </div>
				         <div class='spacer'></div>
				        <h4>Address Information</h4>
				        
				        <div class="form-group">
				           <div class="col-md-6">
		                    <label for="zipCode" class="control-label col-md-5">Address</label>
		                    <div class="col-md-7">
		                    <p class="form-control-static"> <c:out value="${organization.address.addAddress}"></c:out></p> 
		                                    
		                 </div>
		                 </div>
		                 
				        
				        <div class="col-md-6">
		                 <label for="countryName" class="control-label col-md-5">Country</label>
		                    <div class="col-md-7">
		                        <p class="form-control-static"> <c:out value="${organization.address.country.couName}"></c:out></p> 
		                                 
		                    </div>
		                 </div>
				        </div>
				        
				        <div class="form-group">
				          
				           <div class="col-md-6">
		                 <label for="countyName" class="control-label col-md-5">County</label>
		                    <div class="col-md-7">
		                      <p class="form-control-static"> <c:out value="${organization.address.county.countyName}"></c:out></p>              
		                 </div>
		                 </div>
				           
		                  <div class="col-md-6">
		                 <label for="cityName" class="control-label col-md-5">City</label>
		                    <div class="col-md-7">
		                      <p class="form-control-static"> <c:out value="${organization.address.town.ctName}"></c:out></p>
		                 </div>
		                 </div>
				        </div>
				        
				        <div class="form-group">
				           
				             <div class="col-md-6">
		                    <label for="zipCode" class="control-label col-md-5">Zip Code</label>
		                    <div class="col-md-7">
		                    <p class="form-control-static"> <c:out value="${organization.address.addZipCode}"></c:out></p>                
		                 </div>
		                 </div>
				          
				          </div>
				        
				         <div class='spacer'></div>
				        <h4>Other Information</h4>
				        
				         <div class="form-group">
				          
				           <div class="col-md-6">
		                 <label for="currencyName" class="control-label col-md-5">Currency</label>
		                    <div class="col-md-7">
		                      <p class="form-control-static"> <c:out value="${organization.currency.curName}"></c:out></p> 
		                                    
		                 </div>
		                 </div>
				           
		                
				        </div>
				        
				        <div class="form-group">
				           
				             <div class="col-md-6">
		                    <label for="logo" class="control-label col-md-5">Logo</label>
		                    <div class="col-md-7">
		                     <div class="kv-avatar center-block" style="width:200px">
						        <img alt="" src="<c:url value='/protected/organization/logo'/> ">
						    </div>
						    </div>
		                 </div>
				          
				          </div>
				        
				      </div> 
				      
				     <form:hidden path="orgCode" id="orgCodepk"/> 
                      </form:form>
                      