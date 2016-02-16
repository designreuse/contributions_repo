<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="modal fade" id="productSubclassModal" role="dialog">
    <div class="modal-dialog">
    <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Select Sub Class</h4>
        </div>
        <div class="modal-body" id="subclassModal">
		     <%@ include file="subclassModal.jsp" %>
        </div>
        <div class="modal-footer">
           <button type="button"  class="btn btn-primary" id="saveProductSubclasses" onclick="submitProductSubclasses();">Save</button>
          <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
        </div>
      </div>
      </div>
     </div>
