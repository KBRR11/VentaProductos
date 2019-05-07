package pe.edu.upeu.ventas.entity;

public class DetalleVenta {

	private int iddetalle_venta;
	private int idventas;
	private int idproducto;
	private double precio_venta;
	private int cantidad_venta;
	public DetalleVenta() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DetalleVenta(int iddetalle_venta, int idventas, int idproducto, double precio_venta, int cantidad_venta) {
		super();
		this.iddetalle_venta = iddetalle_venta;
		this.idventas = idventas;
		this.idproducto = idproducto;
		this.precio_venta = precio_venta;
		this.cantidad_venta = cantidad_venta;
	}
	public int getIddetalle_venta() {
		return iddetalle_venta;
	}
	public void setIddetalle_venta(int iddetalle_venta) {
		this.iddetalle_venta = iddetalle_venta;
	}
	public int getIdventas() {
		return idventas;
	}
	public void setIdventas(int idventas) {
		this.idventas = idventas;
	}
	public int getIdproducto() {
		return idproducto;
	}
	public void setIdproducto(int idproducto) {
		this.idproducto = idproducto;
	}
	public double getPrecio_venta() {
		return precio_venta;
	}
	public void setPrecio_venta(double precio_venta) {
		this.precio_venta = precio_venta;
	}
	public int getCantidad_venta() {
		return cantidad_venta;
	}
	public void setCantidad_venta(int cantidad_venta) {
		this.cantidad_venta = cantidad_venta;
	}
	
	
}
