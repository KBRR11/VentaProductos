$(document).ready(function(){
	//alert("hola");
	//listarDesplegable();
	listarCliente();
	listarUsuario();
	listarProductos();
});

$("#botoncli").click(function(){
	
	var nomcliente= $("#nomcliente").val();
	var dnicliente= $("#dnicliente").val();

	
	
	$.post( "vc", {nomcliente:nomcliente,dnicliente:dnicliente, opc:1}).done(function(data){
		      bootbox.alert(data);
				limpiar();
				listar();
				
		} );
});


function agregar(id){

	$("#continuar").click(function (){
		var vendedor= $("#vendedor").val();
		var doc= $("#doc").val();
		var fecha= $("#fecha").val();
	$.post ("vc" , {vendedor:vendedor,id:id,doc:doc,fecha:fecha, opc:3}).done(function(data){
		
		bootbox.alert(data);
	});
	

});
}


/*function listarDesplegable(){
	var i, c =1;
	

	$.get("hc",{opc:"2"},function(data){		
	var d = JSON.parse(data);
		//alert(data);
	for(i=0;i<d.length;i++){
			$("#prod").append("<option value='" + d[i].idproducto+"'>"+d[i].nom_producto+"</option>")

		}
	});
}*/



function listarCliente(){
	var i, c =1;
	

	var i, c =1;
	$.get("vc",{opc:"2"},function(data){
		
		var d = JSON.parse(data);
		
		$('#tablita tbody').empty();
		for(i=0;i<d.length;i++){
			$("#tablita tbody").append("<tr><td>"+c+"</td><td>"+d[i].nombres+"</td><td>"+d[i].dni+"</td>"+
			"<td><a href='#' style='color:#5DADE2' onclick='agregar("+d[i].idcliente+")' data-toggle='modal' data-target='#modalventa'><i class='fas fa-plus'></i></a></td>"
			+"<td><a href='#' style='color:#FF6847' onclick='eliminar("+d[i].idcliente+")'><i class='fas fa-trash'></i></a></td></tr>")
			c++;
		};
	});
	
};

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

function listarProductos(){
	var i, c =1;
	$.get("hc",{opc:"2"},function(data){
		
		var d = JSON.parse(data);
		
		$('#tablapro tbody').empty();
		for(i=0;i<d.length;i++){
			$("#tablapro tbody").append("<tr><td style='color:black'>"+c+"</td><td>"+d[i].nom_categoria+"</td><td>"+d[i].nom_producto+"</td><td>"+d[i].cantidad+"</td><td>"+d[i].precio+
			"</td><td><a href='#' style='color:#1FE79B' onclick='agregarVenta("+d[i].idproducto+")'><i class='fas fa-cart-plus'></i></a></td></tr>")
			c++;
		}
	});
}

	function agregarVenta(id){
		$.post("hc",{id:id,opc:3},function(data){
			var x = JSON.parse(data);
			var product= $("#prod").val(x.nom_producto);
			var precio= $("#prevent").val(x.precio);
			var cantidad= $("#cant").val(x.cantidad);
			var id = $("#id").val(x.idproducto);
			
			$("#botonadd").click(function (){
				var venta= $("#venta").val();// Aqui me quede
				var doc= $("#doc").val();
				var fecha= $("#fecha").val();
			$.post ("vc" , {vendedor:vendedor,id:id,doc:doc,fecha:fecha, opc:3}).done(function(data){
				
				bootbox.alert(data);
			});
			

		});
			
		});	
		}
