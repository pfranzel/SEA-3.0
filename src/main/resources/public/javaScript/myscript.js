//search for unique id=id4711 in index.html
var para = document.getElementById("id4711");
para.textContent = "Hello from JavaScript";

//convert jsonstring to (json)-object
function getJson(convert2json) { 	
	return convert2json.json();		 
}

function getTxtFromJsonUndPackInsHTML(myjson) {
	
	var i = 0;
	var t_header = document.getElementById("thid001");
	var t_body = document.getElementById("tbid001");

	if (myjson.personen.length == 0) {	
		t_header.classList.add("hideit");     // table-header unsichtbar      
	} 
	else {
		t_header.classList.remove("hideit");  // table-header sichtbar
	}		
	
	// table wird neu gebaut
	for (var item of myjson.personen) {
		t_body.insertAdjacentHTML("beforeend",
			"<tr>"
		    	+ `<td> ${++i} </td>` // id automatisch vergeben; Neu: Id wird im Browser gelesen und gespeichert
				+ "<td><img src='" + getIcon(item.salutation)+"'+ width=25px height=25px></td>"
				+ "<td>" + item.id + "</td>"
				+ "<td>" + item.salutation + "</td>"
				+ "<td>" + item.firstname + "</td>"
				+ "<td>" + item.lastname + "</td>"
				+ "<td>" + item.birthdate + "</td>"
				+ "<td>" + item.location + "</td>"
				+ "<td>" + item.email + "</td>"
				+ "<td>" + item.version + "</td>"
			+ "</tr>")
	}
}

function getIcon(salutation) {
	switch (salutation) {
		case "Mr.":
			return 'images/man.png'
		case "Mrs.":
			return 'images/woman.png'
		case "Other":
			return "images/diverse.png"
		default:
			return "images/diverse.png"
	}
}

// Submit/New: read from the Browser-JS and push to Server (method: POST)
function onSubmitClick(event) {
	event.preventDefault();          // verhindert GET Request
	
	var salutation = document.getElementById("salutation").value
	var firstname = document.getElementById("firstname").value
	var lastname = document.getElementById("lastname").value
    var birthdate = document.getElementById("birthdate").value;
	var location = document.getElementById("location").value;
	var email = document.getElementById("email").value;
	var version = document.getElementById("version").value;


	var jsondata = `{"salutation": "${salutation}", "firstname": "${firstname}", "lastname": "${lastname}", "birthdate":"${birthdate}", "location":"${location}", "email":"${email}", "version":"${version}"}`;
	console.log(jsondata);
    
	return fetch("http://localhost:8080/json/person", {
 			method: 'POST',
  			body: jsondata,
			headers: {
    				'Content-Type': 'application/json'
  			}});
} 

// Update: read from the Browser-JS and push/update to Server (method: PUT)
function onUpdateClick(event) {
	event.preventDefault();          // verhindert GET Request
	var id = document.getElementById("id").value
	var salutation = document.getElementById("salutation").value
	var firstname = document.getElementById("firstname").value
	var lastname = document.getElementById("lastname").value
    var birthdate = document.getElementById("birthdate").value;
	var location = document.getElementById("location").value;
	var email = document.getElementById("email").value;
	var version = document.getElementById("version").value;

	var jsondata = `{"id": "${id}",  "salutation": "${salutation}", "firstname": "${firstname}", "lastname": "${lastname}", "birthdate":"${birthdate}", "location":"${location}", "email":"${email}", "version":"${version}"}`;
	console.log(jsondata);
    
	return fetch("http://localhost:8080/json/person", {
 			method: 'PUT',
  			body: jsondata,
			headers: {
    				'Content-Type': 'application/json'
  			}});
} 

function onSearchClick(event) {
	event.preventDefault();          // verhindert GET Request
	var id = document.getElementById("id").value

	return fetch("http://localhost:8080/json/persons/" + id, {
		method: "GET"
	});
}

function onDeleteByIdClick(event) {
	event.preventDefault();          // verhindert GET Request
	var id = document.getElementById("id").value
	
	fetch("http://localhost:8080/json/persons/" + id, {
		method: "DELETE"
	});
}

function onClearClick(event) {
	event.preventDefault();          // verhindert GET Request
	fetch("http://localhost:8080/json/persons/all", {
		method: "DELETE"
	});
}
		
function onRefreshClick() {
	document.getElementById(tbid001).innerHTML="";
	refreshTable();
}

function refreshTable() { 
	// Verbindung mit dem Server für Anzeige aller Personen bzw. fetch lädt die Seite auf dem Server
	fetch("/json/persons/all")
		.then(getJson) 				  	 // entspricht: .then( irgendwas => irgendwas.json() )
		.then(getTxtFromJsonUndPackInsHTML)  // entpricht: cell.textContent = myjson.personen[0].vorname);
}

fetch("http://localhost:8080/json/persons/all")
	.then(getJson) 								//  entspricht: .then( irgendwas => irgendwas.json() )
	.then(getTxtFromJsonUndPackInsHTML)		// entpricht: cell.textContent = myjson.personen[0].vorname);

var input = document.getElementById("submitButton");
input.addEventListener("click", onSubmitClick);
console.log(input);
	
var update = document.getElementById("updateButton");
update.addEventListener("click", onUpdateClick);
console.log();

var del = document.getElementById("deleteByIdButton");
del.addEventListener("click", onDeleteByIdClick );
console.log(del);

var clearall = document.getElementById("clearButton");
clearall.addEventListener("click", onClearClick);

var query = document.getElementById("queryButton")
query.addEventListener("click", onSearchClick)
//	refreshTable();

// Refresh
document.getElementById("refreshButton").addEventListener("click",onRefreshClick);	