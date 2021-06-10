var para = document.getElementById("id4711");
para.textContent = "Hello from js!";

// fetch("http://localhost:8080/personen.json");

function getJson(irgendwas) {

	return irgendwas.json();

	}
	
fetch(personen.json)
	.then( irgendwas => irgendwas.json() )
	.then( json => console.log(myjson.personen));
//	.then( json => console.log(myjson.personen[1].nachname));
	
	