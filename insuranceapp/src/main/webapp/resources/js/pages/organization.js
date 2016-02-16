


$(document).ready(function(){
	 initializeCompanyLogo();
	 var countryName=null;
	 var countryCode=null;
	 var countyName=null;
	 var countyCode=null;
	 var townCode=null;
	 var townName=null;
	 var curCode=null;
	 var curName=null;
	 
	 var orgId = $("#orgCodepk").val();
	 initializeOrgBranches(orgId);
	 initializeOrgBanks(orgId);
	
	
});

function showCountryPop(){
	initializeCountryLov();
	$("#countryPopUp").modal({
		backdrop : "static"
	});
	
}


function showCountyPop(){
	initializeCountyLov();
	$("#countyPopUp").modal({
		backdrop : "static"
	});
	
}

function showTownPop(){
	initializeTownLov();
	$("#townPopUp").modal({
		backdrop : "static"
	});
	
}

function showCurrencyPop(){
	initializeCurrencyLov();
	$("#currencyPopUp").modal({
		backdrop : "static"
	});
	
}


function getContextPath() {
	return window.location.pathname.substring(0, window.location.pathname
			.indexOf("/", 2));
}

function initializeOrgBranches(id){
	

	
	var table = $("#orgBranches").dataTable( {
        "bProcessing": true,
        "bServerSide": true,
        destroy: true,
        searching: true,
        "bStateSave": false,
        "iDisplayLength": 5,
        "iDisplayStart": 0,
        "fnDrawCallback": function () {
        },         
        "sAjaxSource": getContextPath()+"/protected/utilities/getOrgBranches/"+id,
        "aoColumns": [
            { "mData": "obId" },
            { "mData": "obShtDesc" },
            { "mData": "obName" },
            {
            	"mData":  null,   
                "mRender": function (data, type, full) {
             	   return "<button type='button' onclick='editOrgBranch("+full.obId+");' class='btn btn-primary'><i class='fa fa-pencil'></i></button>";
                }
            },
            {
            	"mData":  null,   
                "mRender": function (data, type, full) {
             	   return "<button type='button' onclick='deleteOrgBanks("+full.obId+");' class='btn btn-primary'><i class='fa fa-times'></i></button>";
                }
            }
        ],
        "columnDefs": [
                       {
                           "targets": [ 0 ],
                           "visible": false,
                           "searchable": false
                       }
                   ]
    } );
	
}



function initializeOrgBanks(id){
	
	var table = $("#orgBranks").dataTable( {
        "bProcessing": true,
        "bServerSide": true,
        destroy: true,
        searching: true,
        "bStateSave": false,
        "iDisplayLength": 10,
        "iDisplayStart": 0,
        "fnDrawCallback": function () {
        	
        },         
        "sAjaxSource": getContextPath()+"/protected/utilities/getOrgBanks/"+id,
        "aoColumns": [
            { "mData": "bankCode" },
            { "mData": "bankShtDesc" },
            { "mData": "bankName" },
            {
            	"mData":  null,   
            	"mRender": function (data, type, full) {
              	   return "<button type='button' onclick='deleteOrgBanks("+full.bankCode+");' class='btn btn-primary'><i class='fa fa-pencil'></i></button>";
                 }
            },
            {
            	"mData":  null,   
                "mRender": function (data, type, full) {
                	return "<button type='button' onclick='deleteOrgBanks("+full.bankCode+");' class='btn btn-primary'><i class='fa fa-times'></i></button>";
             }
            }
             
        ],
        "columnDefs": [
                       {
                           "targets": [ 0 ],
                           "visible": false,
                           "searchable": false
                       }
                   ]
    } );
	
}



function initializeCountryLov(){
	
	var table = $("#country").dataTable( {
        "bProcessing": true,
        "bServerSide": true,
        destroy: true,
        searching: true,
        "bStateSave": false,
        "iDisplayLength": 10,
        "iDisplayStart": 0,
        "fnDrawCallback": function () {
        	
        },         
        "sAjaxSource": getContextPath()+"/protected/utilities/getCountries",
        "aoColumns": [
            { "mData": "couCode" },
            { "mData": "couShtDesc" },
            { "mData": "couName" },
             
        ],
        "columnDefs": [
                       {
                           "targets": [ 0 ],
                           "visible": false,
                           "searchable": false
                       }
                   ]
    } );
	
	 $('#country tbody').on( 'click', 'tr', function () {
		 
		 $(this).addClass('success').siblings().removeClass('success');
		 var aData = table.fnGetData( $(this));
		 countryName = aData['couName'];
		 countryCode = aData['couCode'];
		 
	    } );
}

function initializeCountyLov(){
	
	var table = $("#county").dataTable( {
        "bProcessing": true,
        "bServerSide": true,
        destroy: true,
        searching: true,
        "bStateSave": false,
        "iDisplayLength": 10,
        "iDisplayStart": 0,
        "fnDrawCallback": function () {
        	
        },         
        "sAjaxSource": getContextPath()+"/protected/utilities/getCounties/"+countryCode,
        "aoColumns": [
            { "mData": "countyId" },
            { "mData": "countyCode" },
            { "mData": "countyName" },
             
        ],
        "columnDefs": [
                       {
                           "targets": [ 0 ],
                           "visible": false,
                           "searchable": false
                       }
                   ]
    } );
	
	 $('#county tbody').on( 'click', 'tr', function () {
		 
		 $(this).addClass('success').siblings().removeClass('success');
		 var aData = table.fnGetData( $(this));
		 countyName = aData['countyName'];
		 countyCode = aData['countyId'];
		
		 
	    } );
}


function initializeTownLov(){
	
	var table = $("#town").dataTable( {
        "bProcessing": true,
        "bServerSide": true,
        destroy: true,
        searching: true,
        "bStateSave": false,
        "iDisplayLength": 10,
        "iDisplayStart": 0,
        "fnDrawCallback": function () {
        	
        },         
        "sAjaxSource": getContextPath()+"/protected/utilities/getTowns/"+countyCode,
        "aoColumns": [
            { "mData": "ctCode" },
            { "mData": "ctShtDesc" },
            { "mData": "ctName" },
             
        ],
        "columnDefs": [
                       {
                           "targets": [ 0 ],
                           "visible": false,
                           "searchable": false
                       }
                   ]
    } );
	
	 $('#town tbody').on( 'click', 'tr', function () {
		 
		 $(this).addClass('success').siblings().removeClass('success');
		 var aData = table.fnGetData( $(this));
		 townName = aData['ctName'];
		 townCode = aData['ctCode'];
		
		 
	    } );
}


function initializeCurrencyLov(){
	
	var table = $("#currencies").dataTable( {
        "bProcessing": true,
        "bServerSide": true,
        destroy: true,
        searching: true,
        "bStateSave": false,
        "iDisplayLength": 10,
        "iDisplayStart": 0,
        "fnDrawCallback": function () {
        	
        },         
        "sAjaxSource": getContextPath()+"/protected/utilities/getCurrencies",
        "aoColumns": [
            { "mData": "curCode" },
            { "mData": "curIsoCode" },
            { "mData": "curName" },
             
        ],
        "columnDefs": [
                       {
                           "targets": [ 0 ],
                           "visible": false,
                           "searchable": false
                       }
                   ]
    } );
	
	 $('#currencies tbody').on( 'click', 'tr', function () {
		 
		 $(this).addClass('success').siblings().removeClass('success');
		 var aData = table.fnGetData( $(this));
		 curName = aData['curName'];
		 curCode = aData['curCode'];
		
		 
	    } );
}


function selectCountry(){
	$("#txtCountry").val(countryName);
	$("#txtCountryCode").val(countryCode);
	clearLovInputs();
	$('#countryPopUp').modal('hide');
}


function selectCounty(){
	$("#txtCounty").val(countyName);
	$("#txtCountyCode").val(countyCode);
	$("#txtCity").val("");
	$('#countyPopUp').modal('hide');
}


function selectTown(){
	$("#txtCity").val(townName);
	$("#txtCityCode").val(townCode);
	$('#townPopUp').modal('hide');
}

function selectCurrency(){
	$("#txtCurrency").val(curName);
	$("#txtCurCode").val(curCode);
	$('#currencyPopUp').modal('hide');
}


function clearLovInputs(){
	$("#txtCounty").val("");
	$("#txtCity").val("");
	
}

function initializeCompanyLogo(){
	
	$("#avatar").fileinput({
	    overwriteInitial: true,
	    maxFileSize: 1500,
	    showClose: false,
	    showCaption: false,
	    browseLabel: '',
	    removeLabel: '',
	    browseIcon: '<i class="fa fa-folder-open"></i>',
	    removeIcon: '<i class="fa fa-times"></i>',
	    removeTitle: 'Cancel or reset changes',
	    elErrorContainer: '#kv-avatar-errors',
	    msgErrorClass: 'alert alert-block alert-danger',
	    defaultPreviewContent: '<img src="/insuranceapp/protected/organization/logo"  style="width:160px">',
	    layoutTemplates: {main2: '{preview} ' + ' {remove} {browse}'},
	    allowedFileExtensions: ["jpg", "png", "gif"]
	});
	
}


function deleteOrgBranch(code) {
	var opt = {
			 autoOpen: false,
			   modal: true,
			   buttons : {
			        "OK" : function() {
			        	$.get(getContextPath() + "/protected/organization/deleteOrgBranch/"
			        				+ code, function(result) {
			        		 var orgId = $("#orgCodepk").val();
			        		 initializeOrgBranches(orgId);
			        		});    
			        	 $(this).dialog("close");
			        },
			        "Cancel" : function() {
			          $(this).dialog("close");
			        }
			      }
			    };
	
	 $("#dialogBranch").dialog(opt).dialog("open");
	   
	
}

function editOrgBranch(id){

		$.get( getContextPath()
				+ "/protected/organization/getBranchDetails/"+id,
				function(result) {
			       console.log(result);
					$("#branchForm").html(result);
				});

		$("#createBranchModal").modal({
			backdrop : "static"
		});
	
}

function deleteOrgBanks(code) {
	var opt = {
			 autoOpen: false,
			   modal: true,
			   buttons : {
			        "OK" : function() {
			        	$.get(getContextPath() + "/protected/organization/deleteOrgBank/"
		        				+ code, function(result) {
		        		 var orgId = $("#orgCodepk").val();
		        		 initializeOrgBanks(orgId);
		        		});       
			        	 $(this).dialog("close");
			        },
			        "Cancel" : function() {
			          $(this).dialog("close");
			        }
			      }
			    };
	
	 $("#dialogBank").dialog(opt).dialog("open");
}