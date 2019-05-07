$(document).ready(function(){
	//alert("hola");
	listarDesplegable();
	//listar();
	listarUsuario();
});

$("#boton").click(function(){
	var vendedor = $("#vendedor").val();
	var doc= $("#doc").val();
	var nomcliente= $("#nomcliente").val();
	var dnicliente= $("#dnicliente").val();
	var fechaventa= $("#fechaventa").val();
	var prod= $("#prod").val();
	var precio= $("#precio").val();
	var cant= $("#cant").val();
	var id = $("#id").val();
	/*alert(cat+"/"+prod+"/"+precio+"/"+cant);*/
	$.post( "vc", {id:id,vendedor:vendedor,doc:doc,nomcliente:nomcliente,dnicliente:dnicliente,fechaventa:fechaventa,prod:prod,precio:precio,cant:cant,opc:5}).done(function(data){
		        $("#id").val(0);
				bootbox.alert(data);
				limpiar();
				listar();
		} );
});

function listarDesplegable(){
	var i, c =1;
	

	$.get("hc",{opc:"2"},function(data){		
	var d = JSON.parse(data);
		//alert(data);
	for(i=0;i<d.length;i++){
			$("#prod").append("<option value='" + d[i].idproducto+"'>"+d[i].nom_producto+"</option>")

		}
	});
}
function listarUsuario(){
	var i, c =1;
	

	$.get("lc",{opc:"2"},function(data){		
	var d = JSON.parse(data);
		//alert(data);
	for(i=0;i<d.length;i++){
			$("#vendedor").append("<option value='" + d[i].idusuario+"'>"+d[i].nom_user+"</option>")

		}
	});
}