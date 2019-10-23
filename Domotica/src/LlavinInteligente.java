
public class LlavinInteligente {
	
	boolean estado; 
	
	public void abrir() {
		this.estado = true; 
	}
	
	public void cerrar() {
		this.estado = false; 
	}
	
	public boolean getEstado() {
		return this.estado;
	}
}
