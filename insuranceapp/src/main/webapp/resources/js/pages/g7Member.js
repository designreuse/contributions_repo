function initializeMemberDetails(id){
	initializeMemberCredits(id);
	initializeMemberDebits(id);

}

function getContextPath() {
	return window.location.pathname.substring(0, window.location.pathname
			.indexOf("/", 2));
}


function initializeMemberDebits(id){
	
	var table = $("#allMemDebits").dataTable( {
        "bProcessing": true,
        "bServerSide": true,
        destroy: true,
        searching: true,
        "bStateSave": false,
        "iDisplayLength": 10,
        "iDisplayStart": 0,
        "fnDrawCallback": function () {
        	
        },         
        "sAjaxSource": getContextPath()+"/protected/g7Members/getSpecMemDebits/"+id,
        "aoColumns": [
            { "mData": "gmdCode" },
            { "mData": "gmdDebitNo" },
            { "mData": "gmdGeneratedDate" },
            { "mData": "gmdDueDate" },
            { "mData": "gmdAmount" },
            { "mData": "gmdSettled" },
            { "mData": "gmdIntAcrAmt" }
             
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

function initializeMemberCredits(id){
	
	var table = $("#allMemCredits").dataTable( {
        "bProcessing": true,
        "bServerSide": true,
        destroy: true,
        searching: true,
        "bStateSave": false,
        "iDisplayLength": 10,
        "iDisplayStart": 0,
        "fnDrawCallback": function () {
        	
        },         
        "sAjaxSource": getContextPath()+"/protected/g7Members/getSpecMemCredits/"+id,
        "aoColumns": [
            { "mData": "gmcCode" },
            { "mData": "gmcReceiptNo" },
            { "mData": "gmcReceiptDate" },
            { "mData": "gmcReceiptType" },
            { "mData": "gmcReceiptNarrative" },
            { "mData": "gmcAmount" },
            { "mData": "gmcAllocatedAmt" }
             
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