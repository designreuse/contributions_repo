<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="modal fade" id="productGroupModal" role="dialog">
    <div class="modal-dialog">
    <form:form class="form-horizontal" role="form" commandName="productGroup" method="post"
    action="createProductGroup">
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Create Product Group</h4>
        </div>
        <div class="modal-body">
            
		  <div class="form-group">
		    <label class="control-label col-sm-2" for="prgDescn">Description</label>
		    <div class="col-sm-10">
		      <form:input path="prgDescn"  placeholder="Enter Product Group Description"/>
		    </div>
		  </div>
 

        </div>
        <div class="modal-footer">
           <button type="submit" id="saveProdGroup" class="btn btn-default">Save</button>
          <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
        </div>
      </div>
      </form:form>
    </div>
  </div>