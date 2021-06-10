function getJson(irgendwas) {
	return irgendwas.json();
}
function getTxtFromJsonUndPackInsHTML(myjson) {
	var cell_firstname = document.getElementById("id001");
	cell_firstname.textContent = myjson.personen[0].firstname;
	var cell_lastname = document.getElementById("id002");
	cell_lastname.textContent = myjson.personen[0].lastname;
	document.getElementById("id003").textContent = myjson.personen[0].salutation;
}
fetch("personen.json")
	.then(getJson) 								//  entspricht: .then( irgendwas => irgendwas.json() )
	.then(getTxtFromJsonUndPackInsHTML) 		// entpricht: cell.textContent = myjson.personen[0].vorname);
