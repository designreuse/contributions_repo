<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row">
    <div id="dialogBank" title="Confirmation Required" style="display: none;">
  Are you sure you want to delete this Bank?
</div>

 <div id="dialogBranch" title="Confirmation Required" style="display: none;">
  Are you sure you want to delete this Branch?
</div>
    <div class="col-md-12 col-sm-12">
                <div class="panel-group">
                  <div class="panel panel-primary">
                    <div class="panel-heading">
                      <h4 class="panel-title">
                        <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
                          Organization Definition
                        </a>
                      </h4>
                    </div>
                    <div id="collapseOne" class="panel-collapse collapse in">
                      <div class="panel-body">
                          <h4>Organization Details</h4>
                          
                          
                          <c:choose>
						    <c:when test="${organization.formAction=='A'}">
						        <jsp:include page="orgForm.jsp"></jsp:include>
						    </c:when>
						    <c:otherwise>
						         <jsp:include page="orgFormDetails.jsp"></jsp:include>
						    </c:otherwise>
						</c:choose>
                      </div>
                    </div>
                  </div>
                  <div class="panel panel-primary">
                    <div class="panel-heading">
                      <h4 class="panel-title">
                        <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">
                          Organization Branches
                        </a>
                      </h4>
                    </div>
                    <div id="collapseTwo" class="panel-collapse collapse">
                      <div class="panel-body">
                        <h4>Branch Details</h4>
                          <table id="orgBranches" class="table table-hover table-bordered"
							cellspacing="0" width="100%">
							<thead>
								<tr>
									<th>Code</th>
									<th>Branch ID</th>
									<th>Branch Name</th>
									<th width="5%"> </th>
									<th width="5%"> </th>
								</tr>
							</thead>
						</table>
                      </div>
                    </div>
                  </div>
                  
                  <div class="panel panel-primary">
                    <div class="panel-heading">
                      <h4 class="panel-title">
                        <a data-toggle="collapse" data-parent="#accordion" href="#collapseThree">
                          Organization Banks
                           
                         
                        </a>
                      </h4>
                    </div>
                    <div id="collapseThree" class="panel-collapse collapse">
                      <div class="panel-body">
                        <h4>Bank Details</h4>
                         <table id="orgBranks" class="table table-hover table-bordered"
							cellspacing="0" width="100%">
							<thead>
								<tr>
									<th>Code</th>
									<th>Bank ID</th>
									<th>Bank Name</th>
									<th width="5%"></th>
									<th width="5%"></th>
								</tr>
							</thead>
						</table>
                       </div>
                    </div>
                  </div>
                 
                </div>
              </div>
</div>



 <jsp:include page="../commons/modals.jsp"></jsp:include>


 <script src="<c:url value='/resources/js/pages/organization.js' />"></script>