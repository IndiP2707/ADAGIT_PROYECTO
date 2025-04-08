package GIT;

public class reserva {
	private String cliente;
	private String destino;
     private float precio;
     private String fecha;
     public reserva siguiente;
     public reserva anterior;
   
     
    
	public reserva(String cliente, String destino, float precio, String fecha) {

		this.cliente = cliente;
		this.destino = destino;
		this.precio = precio;
		this.fecha = fecha;

	}

	public String getCliente() {
		return cliente;
	}



	public void setCliente(String cliente) {
		this.cliente = cliente;
	}



	public String getDestino() {
		return destino;
	}



	public void setDestino(String destino) {
		this.destino = destino;
	}



	public float getPrecio() {
		return precio;
	}



	public void setPrecio(float precio) {
		this.precio = precio;
	}



	public String getFecha() {
		return fecha;
	}



	public void setFecha(String fecha) {
		this.fecha = fecha;
	}



	public reserva getSiguiente() {
		return siguiente;
	}



	public void setSiguiente(reserva siguiente) {
		this.siguiente = siguiente;
	}



	public reserva getAnterior() {
		return anterior;
	}



	public void setAnterior(reserva anterior) {
		this.anterior = anterior;
	}
}
