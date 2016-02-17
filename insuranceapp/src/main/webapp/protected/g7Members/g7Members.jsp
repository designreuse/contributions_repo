<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

			<div class="col-md-3 col-sm-6">
			  <div id="accordion2" class="panel-group">
			        <div class="panel panel-default">
			            <div class="panel-heading">
			                <h4 class="panel-title">
			                    <a data-toggle="collapse" data-parent="#accordion" href="#collapseMain">G7 Members</a>
			                </h4>
			            </div>
			            <div id="collapseMain" class="panel-collapse collapse in">
			                <div class="panel-body">
			                    <div class="box-body no-padding">  
			                          <div class="bodycontainer scrollable" style="max-height: 300px; width: 100%;">
			                            <div id="g7MemberData">
			                             <%@ include file="g7MembersList.jsp" %>
										</div>
									  </div>
			                   </div>
			                </div>
			            </div>
			        </div>
			     </div>
            </div>
            
            <div class="col-md-9 col-sm-6">
            	<div id="accordion" class="panel-group">
            		<div class="panel panel-default">
			            <div class="panel-heading">
			                <h4 class="panel-title">
			                    <a data-toggle="collapse" data-parent="#accordion" href="#collapseThree">Member Summary</a>
			                </h4>
			            </div>
			            <div id="collapseThree" class="panel-collapse collapse in">
			                <div class="panel-body">
			                    <div class="box-body no-padding">  
			                          <div class="bodycontainer scrollable" style="max-height: 300px; width: 100%;">
			                            <div id="g7MemberSummaryData">
			                             <%@ include file="g7MemberSummary.jsp" %>
										</div>
									  </div>
			                   </div>
			                </div>
			            </div>
			        </div>
			        <div class="panel panel-default">
			            <div class="panel-heading">
			                <h4 class="panel-title">
			                    <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">Member Debit Transactions</a>
			                </h4>
			            </div>
			            <div id="collapseOne" class="panel-collapse collapse">
			                <div class="panel-body">
			                    <div class="box-body no-padding">  
			                          <div class="bodycontainer scrollable" style="max-height: 350px; width: 100%;">
			                            <div id="g7MemberDtData">
			                             <%@ include file="g7MemberDebitsList.jsp" %>
										</div>
									  </div>
			                   </div>
			                </div>
			            </div>
			        </div>
			        <div class="panel panel-default">
			            <div class="panel-heading">
			                <h4 class="panel-title">
			                    <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">Member Credit Transactions</a>
			                </h4>
			            </div>
			            <div id="collapseTwo" class="panel-collapse collapse">
			                <div class="panel-body">
			                    <div class="box-body no-padding">  
			                          <div class="bodycontainer scrollable" style="max-height: 300px; width: 100%;">
			                            <div id="g7MemberCtData">
			                             <%@ include file="g7MemberCreditsList.jsp" %>
										</div>
									  </div>
			                   </div>
			                </div>
			            </div>
			        </div>
			    </div>	           
            </div> 
            
             <script src="<c:url value='/resources/js/pages/g7Member.js' />"></script>