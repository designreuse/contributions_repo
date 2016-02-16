<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

               <div class="col-md-3 col-sm-6">
               <div class="box"> 
                <div class="box-header">
                 <h3 class="box-title">Product Groups</h3>
                </div>
                
                   <div class="box-body no-padding">  
                          <div class="bodycontainer scrollable" style="max-height: 300px; width: 100%;">
                          <select id="prodGroup" name="prod">
                                <option value="-1000">Select Product Group</option>
                                <c:forEach var="aff" items="${producGroups}">
                                    <option value="${aff.prgCode}">${aff.prgDescn}</option>
                                </c:forEach>
                                <option value="-2000">Create Product Group</option>
                            </select>
                            <div class='spacer'></div>
                            <div id="productData">
                             <%@ include file="productsList.jsp" %>
							 </div>
							 </div>
                       </div>
                    </div>
                  </div>
              <div class="col-md-9 col-sm-6">
              <div class="nav-tabs-custom">
                     <ul class="nav nav-tabs" role="tablist" id="templatemo-tabs">
                  <li class="active"><a href="#home" role="tab" data-toggle="tab">Product Details</a></li>
                  <li id="prodSubclass" style="display:none;"><a href="#subclass" role="tab" data-toggle="tab">Product Sub Classes</a></li>
                </ul>

                <!-- Tab panes -->
                <div class="tab-content">
                  <div class="tab-pane fade in active" id="home">
                      <%@ include file="productsForm.jsp" %>
                  </div>
                  <div class="tab-pane fade" id="subclass">
                       <%@ include file="subclassList.jsp" %>
                  </div>
                 
                </div> <!-- tab-content --> 
                </div>
              </div> 
 
 <jsp:include page="modals/productModals.jsp"></jsp:include>
  <jsp:include page="modals/prodSubclasses.jsp"></jsp:include>
 <jsp:include page="modals/editProdSubclassModal.jsp"></jsp:include>
  
 
 <script src="<c:url value='/resources/js/pages/product.js' />"></script>