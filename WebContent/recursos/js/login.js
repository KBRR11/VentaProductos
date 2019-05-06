
$(document).ready(function(){
	$("#login").click(function(){
		var user= $("#user").val();
		var pass= $("#pass").val();
		var id = $("#id").val();
		if (user === "" || pass === ""){
			alert("Por Favor, Ingrese un Usuario y contraseña");
		}else{
			validar(user,pass);
		}
	});
});

function validar(user,pass){
	var i;
	$.get("lc",{user:user, pass:pass, opc:"1"}, function(data){
	 
		var d = JSON.parse(data);
	
	
	if (d.idusuario==0) {
		$("#user").popover({
			  trigger: 'focus',
			  content: 'Usuario y/o contraseña incorrectos',
			  placement:'top',
		        title:  'ATENCION!!'
		});
		$("#user").popover('show');
	}else {
		window.location='index.html';
	}
	
	});
}