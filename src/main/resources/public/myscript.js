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
	var tabelle = document.getElementById("tid001");
	var i=0;
	for (var element of myjson.personen) {
		// neue Zeile am Ende der exist. Tabelle anfügen
		i++;
		tabelle.insertAdjacentHTML("beforeend", "<tr>"
			+ `<td> ${i} </td>`
			+ "<td><img src='" + getIcon(element.salutation) + "'> </td>"
			+ "<td>" + element.salutation + "</td>"
			+ "<td>" + element.firstname + "</td>"
			+ "<td>" + element.lastname + "</td>"
			+ "</tr>")
		//		document.getElementById("id003").textContent = laufvariable.anrede;
		//		document.getElementById("id001").textContent = laufvariable.vorname;
		//		document.getElementById("id002").textContent = laufvariable.nachname;
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


fetch("personen.json")
	.then(getJson) 								//  entspricht: .then( irgendwas => irgendwas.json() )
	.then(getTxtFromJsonUndPackInsHTML) 		// entpricht: cell.textContent = myjson.personen[0].vorname);