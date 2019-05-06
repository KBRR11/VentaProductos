package pe.edu.upeu.ventas.entity;

public class Cliente {

	private int idcliente;
	private String nombres;
	private String dni;
	
	public Cliente() {
		
	}

	public Cliente(int idcliente, String nombres, String dni) {
		super();
		this.idcliente = idcliente;
		this.nombres = nombres;
		this.dni = dni;
	}

	public int getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
	
	
}
