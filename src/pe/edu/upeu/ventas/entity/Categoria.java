package pe.edu.upeu.ventas.entity;

public class Categoria {
private int idcategoria;
private String nom_categoria;

public Categoria() {

}

public Categoria(int idcategoria, String nom_categoria) {
	super();
	this.idcategoria = idcategoria;
	this.nom_categoria = nom_categoria;
}

public int getIdcategoria() {
	return idcategoria;
}

public void setIdcategoria(int idcategoria) {
	this.idcategoria = idcategoria;
}

public String getNom_categoria() {
	return nom_categoria;
}

public void setNom_categoria(String nom_categoria) {
	this.nom_categoria = nom_categoria;
}


}
