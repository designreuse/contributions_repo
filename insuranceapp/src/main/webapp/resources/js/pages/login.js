
$(document).ready(function(){
	if(displayErrorMessage()){
		$('#login-error').show();
	}
	else{
		$('#login-error').hide();
	}
	
})


function displayErrorMessage(){
	var url =  $(location).attr('href'); 
	return (url.indexOf("error") >= 0);
}