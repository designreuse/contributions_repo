<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<form:form class="form-horizontal" role="form" commandName="product"
                       method="post" action="createProduct" id="productForm">
				          <div class="spacer"></div>
				          <div id="errorArea" style="display:none;" class="alert alert-success alert-dismissible" role="alert">
		                      <button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
		                      <div id="message"></div>
                          </div>
                     <div class="spacer"></div>
				        <div class="form-group">
				            <div class="col-md-6">
		                    <label for="proShtDesc" class="control-label col-md-5">Prod. Sht Desc</label>
		                     <div class="col-md-7">
		                     <form:input path="proShtDesc" class="form-control" placeholder="Sht Desc"/>   
		                     </div>               
		                    </div>
		                    <div class="col-md-6">
		                    <label for="proDesc" class="control-label col-md-5">Prod. Desc</label>
		                    <div class="col-md-7">
		                    <form:input path="proDesc" class="form-control" placeholder="Description"/>
		                    </div>    
		                    </div>   
				        </div>
				     
				        <div class="form-group">
				          <div class="col-md-6">
		                    <label for="proWef" class="control-label col-md-5">WEF</label>
		                     <div class="col-md-7">
		                     <form:input path="proWef" class="form-control datepicker" placeholder="DD-MM-YYYY"/>                  
		                 </div>
		                 </div>
		                 <div class="col-md-6">
		                  <label for="proWet" class="control-label col-xs-5">WET</label>
		                    <div class="col-md-7">
		                     <form:input path="proWet" class="form-control datepicker" placeholder="DD-MM-YYYY"/>                  
		                 </div>
		                 </div>
				        </div>
				       
				        
				          <div class="form-group">
				           <div class="col-md-6">
		                    <label for="proPolicyPrefix" class="control-label col-md-5">Policy Prefix</label>
		                    <div class="col-md-7">
		                     <form:input path="proPolicyPrefix" class="form-control" placeholder="Product Policy Prefix"/>                  
		                 </div>
		                 </div>
		                  <div class="col-md-6">
		                 <label for="proClaimPrefix" class="control-label col-md-5">Claim Prefix</label>
		                    <div class="col-md-7">
		                     <form:input path="proClaimPrefix" class="form-control" placeholder="Claim Policy Prefix"/>                  
		                 </div>
		                 </div>
				        </div>
				        
				        
				        
				        <div class="form-group">
				             <div class="col-md-6">
		                    <label for="proRenewable" class="control-label col-md-5">Renewable?</label>
		                    <div class="col-md-7">
		                      <form:select path="proRenewable" class="form-control">
		                        <form:option value="N">No</form:option>
		                       <form:option value="Y">Yes</form:option>
		                      </form:select>
		                 </div>
		                 </div>
		                  <div class="col-md-6">
		                  <label for="proSameDayRenewal" class="control-label col-md-5">Same Day Renewal?</label>
		                    <div class="col-md-7">
		                      <form:select path="proSameDayRenewal" class="form-control">
		                        <form:option value="N">No</form:option>
		                       <form:option value="Y">Yes</form:option>
		                      </form:select>
		                 </div>
		                 </div>
				        </div>
				        
				         <div class="form-group">
				             <div class="col-md-6">
		                    <label for="proMultClass" class="control-label col-md-5">Multiclass?</label>
		                    <div class="col-md-7">
		                      <form:select path="proMultClass" class="form-control">
		                        <form:option value="N">No</form:option>
		                       <form:option value="Y">Yes</form:option>
		                      </form:select>
		                 </div>
		                 </div>
		                  <div class="col-md-6">
		                  <label for="proMinPrem" class="control-label col-md-5">Min Premium</label>
		                    <div class="col-md-7">
		                      <form:input path="proMinPrem"  class="form-control"/>
		                 </div>
		                 </div>
				        </div>
				        <form:hidden path="proCode" id="proCode"/>
				        <form:hidden path="prgCode" id="prgCode"/>
				    
				           <div class='spacer'></div>
				          <div class="form-actions">  
				        <input type="button"  onclick="submitProduct();" class="btn btn-primary" id="btnSaveProduct" value="Save" >
				        </div>
                      </form:form>
                      
                      