/**
 * 
 */

function registe(){
	/* alert("register"); */
	var r = document.getElementById('reg');
	var l = document.getElementById('log');
	var a = document.getElementById('adLog');
	/* alert(r.style.display);
	alert(r.style.display); */
	
	r.style.display = 'block';
	a.style.display = 'none';
	l.style.display = 'none';
}

function logi(){
	/* alert("login"); */
	var r = document.getElementById('reg');
	var l = document.getElementById('log');
	var a = document.getElementById('adLog');
	/* alert(r.style.display); */
	/* alert(r.style.display); */
	
	
	r.style.display = 'none';
	l.style.display = 'block';
	a.style.display = 'none';
}

function adm(){
	/* alert("login"); */
	var r = document.getElementById('reg');
	var l = document.getElementById('log');
	var a = document.getElementById('adLog');
	/* alert(r.style.display); */
	/* alert(r.style.display); */
	
	
	r.style.display = 'none';
	l.style.display = 'none';
	a.style.display = 'block';
}