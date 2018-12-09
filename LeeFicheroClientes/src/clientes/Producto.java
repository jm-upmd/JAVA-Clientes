package clientes;

public class Producto {
	private long idProducto;
	private String nombreProducto;
	private int idProveedor;
	private int idCategoría;
	private int cantidadPorUnidad;
	private float precioUnidad;
	private int unidadesEnExistencia;
	private int unidadesEnPedido;
	private int nivelNuevoPedido;
	private boolean suspendido;
	
	// Constructor
	public Producto(long idProducto, String nombreProducto, int idProveedor, int idCategoría, int cantidadPorUnidad,
			float precioUnidad, int unidadesEnExistencia, int unidadesEnPedido, int nivelNuevoPedido,
			boolean suspendido) {
		super();
		this.idProducto = idProducto;
		this.nombreProducto = nombreProducto;
		this.idProveedor = idProveedor;
		this.idCategoría = idCategoría;
		this.cantidadPorUnidad = cantidadPorUnidad;
		this.precioUnidad = precioUnidad;
		this.unidadesEnExistencia = unidadesEnExistencia;
		this.unidadesEnPedido = unidadesEnPedido;
		this.nivelNuevoPedido = nivelNuevoPedido;
		this.suspendido = suspendido;
	}
	
	// Gets & Sets
	public long getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(long idProducto) {
		this.idProducto = idProducto;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public int getIdProveedor() {
		return idProveedor;
	}
	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}
	public int getIdCategoría() {
		return idCategoría;
	}
	public void setIdCategoría(int idCategoría) {
		this.idCategoría = idCategoría;
	}
	public int getCantidadPorUnidad() {
		return cantidadPorUnidad;
	}
	public void setCantidadPorUnidad(int cantidadPorUnidad) {
		this.cantidadPorUnidad = cantidadPorUnidad;
	}
	public float getPrecioUnidad() {
		return precioUnidad;
	}
	public void setPrecioUnidad(float precioUnidad) {
		this.precioUnidad = precioUnidad;
	}
	public int getUnidadesEnExistencia() {
		return unidadesEnExistencia;
	}
	public void setUnidadesEnExistencia(int unidadesEnExistencia) {
		this.unidadesEnExistencia = unidadesEnExistencia;
	}
	public int getUnidadesEnPedido() {
		return unidadesEnPedido;
	}
	public void setUnidadesEnPedido(int unidadesEnPedido) {
		this.unidadesEnPedido = unidadesEnPedido;
	}
	public int getNivelNuevoPedido() {
		return nivelNuevoPedido;
	}
	public void setNivelNuevoPedido(int nivelNuevoPedido) {
		this.nivelNuevoPedido = nivelNuevoPedido;
	}
	public boolean isSuspendido() {
		return suspendido;
	}
	public void setSuspendido(boolean suspendido) {
		this.suspendido = suspendido;
	}
	

}
