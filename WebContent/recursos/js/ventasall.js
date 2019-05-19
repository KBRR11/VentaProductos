var v = 0;

$(document).ready(function() {

	// alert("hola");
	// listarDesplegable();
	listarCliente();
	listarUsuario();
	listarProductos();
	listarDventa();

	$("#botoncli").click(function() {

		var nomcliente = $("#nomcliente").val();
		var dnicliente = $("#dnicliente").val();

		$.post("vc", {
			nomcliente : nomcliente,
			dnicliente : dnicliente,
			opc : 1
		}).done(function(data) {
			bootbox.alert(data);
			limpiarCliente();
			listarCliente();

		});
	});
});
function limpiarCliente() {
	$("#nomcliente").val("");
	$("#dnicliente").val("");
	$("#nomcliente").focus();
}
function eliminarCliente(id){
	bootbox.confirm("Desea Eliminar este Cliente?", function(result) {                    /*Hay que Terminarlo Fk?*/
	    if(result){
	    	bootbox.alert("Registro Eliminado Correctamente...!", function() {
	    		$.get("vc",{id:id,opc:6},function(data){
	    			listarCliente();
			});
	    	});
			 
	    }else{
	    	bootbox.alert("El registro no se Elimino...!")
	    }}); 
}

function agregar(id) {
	var i, c = 1;
	$.get("vc", {
		opc : "4",
		id : id
	}, function(data) {
		var d = JSON.parse(data);
		$('#tablavent tbody').empty();
		for (i = 0; i < d.length; i++) {
			$("#tablavent tbody")
					.append(
							"<tr><td>"
									+ c
									+ "</td><td>"
									+ d[i].idusuario
									+ "</td><td>"
									+ d[i].idcliente
									+ "</td><td>"
									+ d[i].doc
									+ "</td><td>"
									+ d[i].fecha
									+ "</td>"
									+ "<td><a href='#' style='color:#73C6B6' onclick='cambiar("
									+ d[i].idventas
									+ ")' onclick= 'listarDventa("+d[i].idventas+")' data-toggle='modal' data-target='#modalagregar'><i class='fas fa-shopping-bag'></i></a></td>")
			c++;
		}
	});
	$("#continuar").click(function() {
		var vendedor = $("#vendedor").val();
		var doc = $("#doc").val();
		var fecha = $("#fecha").val();
		$.post("vc", {
			vendedor : vendedor,
			id : id,
			doc : doc,
			fecha : fecha,
			opc : 3
		}).done(function(data) {
			bootbox.alert(data);
            
		});

	});

};



function listarCliente() {

	var i, c = 1;
	$
			.get(
					"vc",
					{
						opc : "2"
					},
					function(data) {

						var d = JSON.parse(data);

						$('#tablita tbody').empty();
						for (i = 0; i < d.length; i++) {
							$("#tablita tbody")
									.append(
											"<tr><td>"
													+ c
													+ "</td><td>"
													+ d[i].nombres
													+ "</td><td>"
													+ d[i].dni
													+ "</td>"
													+ "<td><a href='#' style='color:#5DADE2' onclick='agregar("
													+ d[i].idcliente
													+ ")' data-toggle='modal' data-target='#modalventa'><i class='fas fa-plus'></i></a></td>"
													+ "<td><a href='#' style='color:#FF6847' onclick='eliminarCliente("
													+ d[i].idcliente
													+ ")'><i class='fas fa-trash'></i></a></td></tr>")
							c++;
						}
						;
					});

};
function listarDventa(id){
	var i, c = 1;
	 
	$.get("vc", {
		opc : "6",
		id : id
	}, function(data) {
		
		var d = JSON.parse(data);
		$('#tabladv tbody').empty();
		for (i = 0; i < d.length; i++) {
			$("#tabladv tbody")
					.append(
							"<tr><td>"
									+ c
									+ "</td><td>"
									+ d[i].idventa
									+ "</td><td>"
									+ d[i].idproducto
									+ "</td><td>"
									+ d[i].precio_venta
									+ "</td><td>"
									+ d[i].cantidad_venta
									+ "</td>"
									+ "<td><a href='#' style='color:#73C6B6' onclick='cambiar("
									+ d[i].iddetalle_venta
									+ ")' data-toggle='modal' data-target='#modalagregar'><i class='fas fa-shopping-bag'></i></a></td>")
			c++;
		}
	});
	}


function listarUsuario() {
	var i, c = 1;

	$.get("lc", {
		opc : "2"
	}, function(data) {
		var d = JSON.parse(data);
		// alert(data);
		for (i = 0; i < d.length; i++) {
			$("#vendedor").append(
					"<option value='" + d[i].idusuario + "'>" + d[i].nom_user
							+ "</option>")

		}
	});

}

function listarProductos() {
	var i, c = 1;
	$
			.get(
					"hc",
					{
						opc : "2"
					},
					function(data) {

						var d = JSON.parse(data);

						$('#tablapro tbody').empty();
						for (i = 0; i < d.length; i++) {
							$("#tablapro tbody")
									.append(
											"<tr><td style='color:black'>"
													+ c
													+ "</td><td>"
													+ d[i].nom_categoria
													+ "</td><td>"
													+ d[i].nom_producto
													+ "</td><td>"
													+ d[i].cantidad
													+ "</td><td>"
													+ (d[i].precio*(1.17))
													+ "</td><td><a href='#' style='color:#1FE79B' onclick='agregarVenta("
													+ d[i].idproducto
													+ ")'><i class='fas fa-cart-plus'></i></a></td></tr>")
							c++;
						}
					});
}
function cambiar(id){
	$("#idvent").val(id);
	
	
}
function operacion(){
	let prevent =  $("#prevent").val();
	let cantvent = $("#cantvent").val();
	
	$("#precioto").val(prevent*cantvent);
	
}

function agregarVenta(id) {
	$.post("hc", {
		id : id,
		opc : 3
	}, function(data) {
		var x = JSON.parse(data);
		var product = $("#prod").val(x.nom_producto);
		var idvent = $("#idvent").val();
		 $("#prevent").val(x.precio*1.17);
		 var prevent =  $("#prevent").val();
		 $( "#cantvent" ).attr('placeholder',"menor o igual a: " + x.cantidad);
		 var cantvent = $("#cantvent").val();
		 var precioto = $("#precioto").val();

		$("#botonadd").click(function() {
			var x = JSON.parse(data);
			alert(id);
			alert(idvent);
			var prevent = $("#prevent").val();
			 var cantvent =$("#cantvent").val();
			 var precioto =$("#precioto").val();
			 alert(cantvent);
			 console.log(precioto);
	if( cantvent > x.cantidad){
				
			$("#cantvent").popover({
				trigger: 'focus',
				  content: 'No Hay Unidades Suficientes en Stock..',
				  placement:'top',
			        title:  'ATENCION!!'
			});
			$("#cantvent").popover('show');
		
	}else{
			
				
				$.post("vc", {
					idvent : idvent,
					id : id,
					precioto : precioto,
					cantvent : cantvent,
					opc : 5
				}).done(function(data) {
					bootbox.alert(data);

				});

			
		}
		});

	});
}
