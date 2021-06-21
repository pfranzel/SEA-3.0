var para = document.getElementById("id4711");
para.textContent = "Hello from JavaScript";
//  fetch("http://localhost:8080/personen.json");
// var cell = document.getElementById("IdSabine");
//	fetch("personen.json")
//		.then( irgendwas => irgendwas.json() )
//		.then(myjson => console.log(myjson.personen[0].vorname));
// json einlesen

function getJson(irgendwas) { 	// irgendwas beinhaltet json mit allen kommunikations-metadaten
	return irgendwas.json();	// irgendwas.json ist der rheine json-inhalt
}

// celle ersetzen
function getTxtFromJsonUndPackInsHTML(myjson) {
		console.log(myjson);

	var tabelle = document.getElementById("tid001");
	var i = 0;
	for (var element of myjson.personen) {
		// neue Zeile am Ende der exist. Tabelle anfügen
		i++;
		tabelle.insertAdjacentHTML("beforeend", "<tr>"
//			+ `<td> ${i} </td>`
			+ "<td>" + element.id + "</td>"
			+ "<td><img src='" + getIcon(element.salutation) + "'> </td>"
			+ "<td>" + element.salutation + "</td>"
			+ "<td>" + element.firstname + "</td>"
			+ "<td>" + element.lastname + "</td>"
			+ "</tr>")
	}
}

function getIcon(salutation) {
	switch (salutation) {
		case "Mr.":
			return 'images/mann.png'
		case "Mrs.":
			return 'images/frau.png'
		default:
			return "images/frau.png"
	}
}

function onSubmitClick(event) {
	event.preventDefault();          // verhindert GET Request
	
	var salutation = document.getElementById("salutation").value
	var firstname = document.getElementById("firstname").value
	var lastname = document.getElementById("lastname").value
	

	/* fetch("http://localhost:8080/json/persons/size")
			.then( response => response.json())
			.then( response => {
    			var id = response["size"]; */
				var id = 1;
				var jsondata = `{"id": "${id}", "salutation": "${salutation}", "firstname": "${firstname}", "lastname": "${lastname}"}`;
				console.log(jsondata);
    			return fetch("http://localhost:8080/json/person", {
 						method: 'POST',
  						body: jsondata,
						headers: {
    					'Content-Type': 'application/json'
  						}});
	//		})
	//		.then( response => response.json())
	//		.then( mydata => processdata(mydata))


/* fetch("http://localhost:8080/json/persons/maxid")
			.then( response => response.json())
			.then( response => {
    			var id = response["size"];
				var jsondata = `{"id": "1", "salutation": "${salutation}", "firstname": "${firstname}", "lastname": "${lastname}"}`;
				console.log(jsondata);
    			return fetch("http://localhost:8080/json/person", {
 						method: 'POST',
  						body: jsondata,
						headers: {
    					'Content-Type': 'application/json'
  						}});
			})
	//		.then( response => response.json())
	//		.then( mydata => processdata(mydata))
	*/
} 

var input = document.getElementById("submitButton");
input.addEventListener("click", onSubmitClick);
//console.log(input);

function onDeleteByIdClick(event) {
	event.preventDefault();          // verhindert GET Request
	var delid = document.getElementById("delid").value
	
	fetch("http://localhost:8080/json/persons/" + delid, {
		method: "DELETE"
	});
}
	
var del = document.getElementById("deleteByIdButton");
del.addEventListener("click", onDeleteByIdClick );
console.log(delid);

function clear(event) {
	event.preventDefault();          // verhindert GET Request
	fetch("http://localhost:8080/json/persons/all", {
		method: "DELETE"
	});
}
	
var clearall = document.getElementById("clearButton");
clearall.addEventListener("click", clear );

fetch("http://localhost:8080/json/persons/all")
	.then(getJson) 								//  entspricht: .then( irgendwas => irgendwas.json() )
	.then(getTxtFromJsonUndPackInsHTML)		// entpricht: cell.textContent = myjson.personen[0].vorname);