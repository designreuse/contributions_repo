<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="modal fade" id="createBranchModal" role="dialog">
    <div class="modal-dialog">
   
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Create/Edit Branches</h4>
        </div>
        <div class="modal-body">
              <div class="alert alert-danger alert-dismissible" role="alert" id="errorDiv" style="display: none;">
                      <button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                      <div id="errorInfo">
                      
                      </div>
               </div>   
                 <form:form id="branchForm" class="form-horizontal" role="form" modelAttribute="OrgBranch" method="post">
    
			          <div class="form-group required">
					    <label class="control-label col-sm-4" for="obShtDesc">Branch Id</label>
					    <div class="col-sm-8">
					       <form:input path="obShtDesc" class="form-control" placeholder="Enter Branch Id"/>
					     
					    </div>
					  </div>
					  
					  <div class="form-group required">
					    <label class="control-label col-sm-4" for="obName">Branch</label>
					    <div class="col-sm-8">
					        <form:input path="obName" class="form-control" placeholder="Enter Subclass"/>
					    </div>
					  </div>
					  <form:hidden path="obId"/>
                 </form:form>
        </div>
        <div class="modal-footer">
           <button type="button" class="btn btn-primary">Save</button>
          <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
        </div>
      </div>
    </div>
  </div>