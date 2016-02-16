$(document)
		.ready(
				function() {

					$("#prodGroup").on('change',function() {
										var productGroup = $("#prodGroup")
												.val();
										if (productGroup == -2000) {
											$("#productGroupModal").modal({
												backdrop : "static"
											});
										} else {

											$("#productData")
													.load(
															getContextPath()
																	+ "/protected/products/getProducts/"
																	+ productGroup
																	+ " #productData");

										}
									});
					initializeDatePicker();
					
					
				});

function getContextPath() {
	return window.location.pathname.substring(0, window.location.pathname
			.indexOf("/", 2));
}

function submitProduct() {

	var data = $('#productForm').serialize();

	$.ajax({
		type : 'POST',
		url : getContextPath() + '/protected/products/createProduct',
		data : data,
		success : function(result) {
			$("#errorArea").show();
			$("#message").html("Product Updated/Created Successfully...");
			clearForm();
		}
	});

}

function editProduct(id) {
	$.get(getContextPath() + "/protected/products/editProduct/" + id, function(
			result) {
		$("#home").html(result);
		$("#prodSubclass").show();
		initializeDatePicker();
	});

	$.get(getContextPath() + "/protected/products/getProductSubclasses/" + id,
			function(result) {
				$("#subclass").html(result);
			});

}

function initializeDatePicker() {
	$(".datepicker").datepicker({
		dateFormat : "dd/mm/yy"
	// changeMonth : true,
	// changeYear : true,
	// showButtonPanel : true
	});
}

function clearForm() {
	resetDialog($("#home"));
	$("#prodSubclass").hide();
	initializeDatePicker();
}

function resetDialog(form) {
	form.find("input").val("");
	$("#btnSaveProduct").val("Save");
}

function showSubclassDialog() {
	var proCode = $("#proCode").val();
	$.get( getContextPath()
			+ "/protected/products/getSubclassesForProduct/" + proCode,
			function(result) {
		        console.log(result);
				$("#subclassModal").html(result);
			});

	$("#productSubclassModal").modal({
		backdrop : "static"
	});
}

function editProductSubclass(clpCode) {

	$.get(getContextPath() + "/protected/products/editProductSubclass/"
			+ clpCode, function(result) {

		$("#editSclclassForm").html(result);
		initializeDatePicker();
		 $("#errorDiv").hide();

	});

	$("#editProductSubclassModal").modal({
		backdrop : "static"
	});
}

function selectAllSubclasses() {
	if ($("#select_all").is(":checked")) {
		$(".selected_data").each(function() {
			this.checked = true;
		});
	} else {
		$(".selected_data").each(function() {
			this.checked = false;
		});
	}
}

function deleteProdSubclass(code) {
	var opt = {
			 autoOpen: false,
			   modal: true,
			   buttons : {
			        "OK" : function() {
			        	$.get(getContextPath() + "/protected/products/deleteProdSubclasses/"
			        				+ code, function(result) {
			        			$("#subclass").html(result);
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

function submitProductSubclasses() {
	var proCode = $("#proCode").val();
	$("#subclassProCode").val(proCode);
	var data = $('#proSubclass').serialize();
	$.ajax({
		type : 'POST',
		url : getContextPath() + '/protected/products/createProductSubclass',
		data : data,
		success : function(result) {
			$('#productSubclassModal').modal('hide');
			editProduct(proCode);
		}
	});

}

function updateProductSubclass() {
	var data = $('#prodSubclassForm').serialize();
	var proCode = $("#proCode").val();
	$.ajax({
		type : 'POST',
		url : getContextPath() + '/protected/products/updateProductSubclass',
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
				$('#editProductSubclassModal').modal('hide');
				editProduct(proCode);
			 }
		}
	});
}



