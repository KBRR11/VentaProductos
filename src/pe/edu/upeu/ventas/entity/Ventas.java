package pe.edu.upeu.ventas.entity;

public class Ventas {
private int idventas;
private int idusuario;
private int idcliente;
private String doc;
private String fecha;
public Ventas() {
	
}
public Ventas(int idventas, int idusuario, int idcliente, String doc, String fecha) {
	super();
	this.idventas = idventas;
	this.idusuario = idusuario;
	this.idcliente = idcliente;
	this.doc = doc;
	this.fecha = fecha;
}
public int getIdventas() {
	return idventas;
}
public void setIdventas(int idventas) {
	this.idventas = idventas;
}
public int getIdusuario() {
	return idusuario;
}
public void setIdusuario(int idusuario) {
	this.idusuario = idusuario;
}
public int getIdcliente() {
	return idcliente;
}
public void setIdcliente(int idcliente) {
	this.idcliente = idcliente;
}
public String getDoc() {
	return doc;
}
public void setDoc(String doc) {
	this.doc = doc;
}
public String getFecha() {
	return fecha;
}
public void setFecha(String fecha) {
	this.fecha = fecha;
}



}
