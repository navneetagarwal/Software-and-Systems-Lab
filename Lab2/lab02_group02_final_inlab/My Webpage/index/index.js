function Show() {
	document.getElementById("hidden1").innerHTML='Name:          Harshal Mahajan \nContact no:  9987220696 \nEmail-ID:      harshal.m@cse.iitb.ac.in';
	document.getElementById("button2").style.background= "#003366";
	document.getElementById("button2").style.color= "white";

}

function Hide() {
	document.getElementById("hidden1").innerHTML=null;
	document.getElementById("button2").style.background= null;
	document.getElementById("button2").style.color= "black";
}