/**
 * Edda Lens Javascript
 */
var databox;
function initiate() {
    databox =  document.getElementById('databox');
    var button = document.getElementById('button');
    button.addEventListener('click', read);
}
function read() {
    var url = 'http://openi.nlm.nih.gov/retrieve.php?query=DOC[Article]AREA[PMID]20398291';
    url = "openApiSearch.jsp";
    var request = new XMLHttpRequest();
//    var request = new JSONHttpRequest();
//    request.overrideMimeType("application/json"); 
    request.addEventListener('load', transferComplete, false);
    request.addEventListener("progress", updateProgress, false);
    request.addEventListener("error", transferFailed, false);
    request.addEventListener("abort", transferCanceled, false);
    request.open('GET', url, true);
//    request.responseType = "application/json";
    request.send();
}
// progress on transfers from the server to the client (downloads)
function updateProgress (oEvent) {
  if (oEvent.lengthComputable) {
    var percentComplete = oEvent.loaded / oEvent.total;
    // ...
  } else {
    // Unable to compute progress information since the total size is unknown
  }
}
function transferComplete(evt) {
  var data = evt.target;
  if (data.status == 200) {
	  var jsonResponseText = data.responseText;
	  var jsonResponse = JSON.parse(jsonResponseText);
	  var ul = buildShallowList(jsonResponse);
	  databox.innerHTML = ul.innerHTML;
  }
}

function transferFailed(evt) {
    //  alert("An error occurred while transferring the file.");
  console.print(evt);
}
function transferCanceled(evt) {
  alert("The transfer has been canceled by the user.");
}
function buildShallowList (obj) {
	  var f;
	  var li;
	  var ul = document.createElement ("ul");
	  alert(obj.length);
	  for (f = 0; f < obj.length; f++) {
	    li = document.createElement ("li");
	    li.appendChild (document.createTextNode (obj[f].value));
	    ul.appendChild (li);
	  }
	  return ul;
	}
function to_ul (obj) {
	  // --------v create an <ul> element
	  var f, li, ul = document.createElement ("ul");
	  // --v loop through its children
	  for (f = 0; f < obj.folder.length; f++) {
	    li = document.createElement ("li");
	    li.appendChild (document.createTextNode (obj.folder[f].title));
	    // if the child has a 'folder' prop on its own, call me again
	    if (obj.folder[f].folder) {
	      li.appendChild (to_ul (obj.folder[f].folder));
	    }
	    ul.appendChild (li);
	  }
	  return ul;
	}
addEventListener('load', initiate);