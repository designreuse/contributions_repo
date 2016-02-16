<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <div class='spacer'></div>
 <a href="<c:url value="/protected/classes"/>" class="btn btn-primary"> 
    Generate Member Statement
 </a>
<table id="allMemDebits" class="table table-hover table-bordered"
	cellspacing="0" width="100%">
	<thead>
		<tr>
			<th>Code</th>
			<th>Debit Number</th>
			<th>Generated Date</th>
			<th>Due Date</th>
			<th>Amount</th>
			<th>Settled</th>
			<th>Interest Acrued</th>
		</tr>
	</thead>
</table>
