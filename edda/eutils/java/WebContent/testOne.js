/**
 * testOne Javascript
 */
var isSubmitting = true;
function initiate() {
	var button = document.getElementById('submitButton');
	button.addEventListener('click', submitForm);
}
function submitForm() {
	
	if (isSubmitting) {
		
		isSubmitting = false;
		
		// retrieve the form values
		var firstName = document.forms["jssond"]["firstName"].value;
		var lastName = document.forms["jssond"]["lastName"].value;
		var email = document.forms["jssond"]["email"].value;
		var mobile = document.forms["jssond"]["mobile"].value;
		var place = document.forms["jssond"]["place"].value;
		var country = document.forms["jssond"]["country"].value;

		var jsonObj = {
			"firstname" : firstName,
			"lastName" : lastName,
			"email" : email,
			"mobile" : mobile,
			"place" : place,
			"country" : country
		};
		
		var jsonString = JSON.stringify(jsonObj);
		postFormData(jsonString);
	}
}
function postFormData(jsonString) {
	  var request = new XMLHttpRequest();
	  request.open('POST', 'testOne.jsp', true);
	  var formData  = new FormData();
	  formData.append("jsonData", jsonString);
	  request.addEventListener('load', function(event) {
	    isSubmitting = true;
	  });
	  request.addEventListener('error', function(event) {
	    alert('Error while submitting form');
	  });
	  request.send(formData);
	}
addEventListener('load', initiate);