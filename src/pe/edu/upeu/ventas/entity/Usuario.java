package pe.edu.upeu.ventas.entity;

public class Usuario {

	private int idusuario;
	private int idrol;
	private String nom_user;
	private String clave;
	
	public Usuario() {
		
	}

	public Usuario(int idusuario, int idrol, String nom_user, String clave) {
		super();
		this.idusuario = idusuario;
		this.idrol = idrol;
		this.nom_user = nom_user;
		this.clave = clave;
	}

	public int getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	public int getIdrol() {
		return idrol;
	}

	public void setIdrol(int idrol) {
		this.idrol = idrol;
	}

	public String getNom_user() {
		return nom_user;
	}

	public void setNom_user(String nom_user) {
		this.nom_user = nom_user;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}
	
	
	
	
}
