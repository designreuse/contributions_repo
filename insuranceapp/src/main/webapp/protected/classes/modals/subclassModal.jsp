<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="modal fade" id="editSubclassModal" role="dialog">
    <div class="modal-dialog">
   
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Create/Edit Sub Class</h4>
        </div>
        <div class="modal-body">
              <div class="alert alert-danger alert-dismissible" role="alert" id="errorDiv" style="display: none;">
                      <button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                      <div id="errorInfo">
                      
                      </div>
               </div>   
              <div id="editSclclassForm">
              <%@ include file="subclassform.jsp" %>
              </div>
        </div>
        <div class="modal-footer">
           <button type="button" onclick="submitSubclass();" class="btn btn-primary">Save</button>
          <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
        </div>
      </div>
    </div>
  </div>