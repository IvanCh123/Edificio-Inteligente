public abstract class Actuador {

	protected boolean estado;
	protected String tipoActuador;
	
	public void encender(){
		estado = true; 
	}
	
	public void apagar() {
		estado = false; 
	}
	
	public boolean getEstado() {
		return this.estado;
	}
	
	protected abstract Actuador crearActuador();
}
