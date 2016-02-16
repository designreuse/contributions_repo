$(document).ready(function(){
	
	initializeDatePicker();
	
});


function newSubclassDialog() {
	var claCode = $("#claPk").val();
	console.log(claCode);
	$.get( getContextPath()
			+ "/protected/classes/newSubclass/"+claCode,
			function(result) {
				$("#editSclclassForm").html(result);
				initializeDatePicker();
				$("#errorDiv").hide();
			});
	$("#editSubclassModal").modal({
		backdrop : "static"
	});
}

function editSubclassDialog(code) {
	$.get( getContextPath()
			+ "/protected/classes/editSubclass/"+code,
			function(result) {
				$("#editSclclassForm").html(result);
				initializeDatePicker();
				 $("#errorDiv").hide();
			});

	$("#editSubclassModal").modal({
		backdrop : "static"
	});
}


function submitSubclass(){
	var claCode = $("#claPk").val();
	console.log(claCode);
	var data = $('#prodSubclassForm').serialize();
	$.ajax({
		type : 'POST',
		url : getContextPath() + '/protected/classes/createSubclass',
		data : data,
		success : function(response) {
			 if(response.status == "Error"){
				 errorInfo = "";
				 for(i =0 ; i < response.result.length ; i++){
					 errorInfo += "<br>" + (i + 1) +". " + response.result[i].code;
				 }
				 $("#errorDiv").show();
				 $('#errorInfo').html("Please correct following errors: " + errorInfo);
			 }else{
			    $('#editSubclassModal').modal('hide');
			    editClass(claCode);
		     }
		}
	});
}


function editClass(id) {
	$.get(getContextPath() + "/protected/classes/editClass/" + id, function(
			result) {
		$("#classformdiv").html(result);
		initializeDatePicker();
	});
	
	$.get(getContextPath() + "/protected/classes/subclasses/" + id, function(
			result) {
		$("#subcldetails").show();
		$("#subclassdet").html(result);
	});
}


function getContextPath() {
	return window.location.pathname.substring(0, window.location.pathname
			.indexOf("/", 2));
}


function newClasses(){
	initializeDatePicker();
	resetDialog($("#classForm"));
	$("#btnNewClass").val("New");
	$("#btnSaveClass").val("Save");
	
}


function resetDialog(form) {
	form.find("input").val("");
	
}


function initializeDatePicker() {
	$(".datepicker").datepicker({
		dateFormat : "dd/mm/yy"
	// changeMonth : true,
	// changeYear : true,
	// showButtonPanel : true
	});
}


function deleteSubclass(code) {
	var opt = {
			 autoOpen: false,
			   modal: true,
			   buttons : {
			        "OK" : function() {
			        	$.get(getContextPath() + "/protected/classes/deleteSubclass/"
			        				+ code, function(result) {
			        			$("#subclassdet").html(result);
			        		});    
			        	 $(this).dialog("close");
			        },
			        "Cancel" : function() {
			          $(this).dialog("close");
			        }
			      }
			    };
	
	 $("#dialog").dialog(opt).dialog("open");
	   
	
}