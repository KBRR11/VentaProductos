$(document).ready(function(){
	//alert("hola");
	listarDesplegable();
	listar();
});

$("#boton").click(function(){
	var cat= $("#cat").val();
	var prod= $("#prod").val();
	var precio= $("#precio").val();
	var cant = $("#cant").val();
	var id = $("#id").val();
	/*alert(cat+"/"+prod+"/"+precio+"/"+cant);*/
	$.post( "hc", {id:id,cat:cat,prod:prod,precio:precio,cant:cant,opc:5}).done(function(data){
		        $("#id").val(0);
				bootbox.alert(data);
				limpiar();
				listar();
		} );
});

function listarDesplegable(){
	var i, c =1;
	

	$.get("hc",{opc:"1"},function(data){		
	var d = JSON.parse(data);
		//alert(data);
	for(i=0;i<d.length;i++){
			$("#cat").append("<option value='" + d[i].idcategoria+"'>"+d[i].nom_categoria+"</option>")

		}
	});
}
function listar(){
	var i, c =1;
	$.get("hc",{opc:"2"},function(data){
		
		var d = JSON.parse(data);
		
		$('#tablita tbody').empty();
		for(i=0;i<d.length;i++){
			$("#tablita tbody").append("<tr><td style='color:blue'>"+c+"</td><td>"+d[i].nom_categoria+"</td><td>"+d[i].nom_producto+"</td><td>"+d[i].cantidad+"</td><td>"+d[i].precio+
			"</td><td><a href='#' style='color:green' onclick='modificar("+d[i].idproducto+")'><i class='far fa-edit'></i></a></td><td><a href='#' style='color:red' onclick='eliminar("+d[i].idproducto+")'><i class='far fa-trash-alt'></i></a></td></tr>")
			c++;
		}
	});
}


function eliminar(id){	
	bootbox.confirm("Desea Eliminar?", function(result) {
    if(result){
    	bootbox.alert("Registro Eliminado Correctamente...!", function() {
    		$.get("hc",{id:id,opc:4},function(data){
				listar();
		});
    	});
		 
    }else{
    	bootbox.alert("El registro no se Elimino...!")
    }}); 
}
function modificar(id){
	$.post("hc",{id:id,opc:3},function(data){
		var x = JSON.parse(data);
		var category= $("#cat").val(x.idcategoria);
		var product= $("#prod").val(x.nom_producto);
		var precio= $("#precio").val(x.precio);
		var cantidad= $("#cant").val(x.cantidad);
		var id = $("#id").val(x.idproducto);		
	});
}
function limpiar(){
	$("#cat").val("");
	$("#prod").val("");
	$("#precio").val("");
	$("#cant").val("");
	$("#prod").focus();
}