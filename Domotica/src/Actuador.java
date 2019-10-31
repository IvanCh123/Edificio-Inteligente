public abstract class Actuador {

	protected boolean estado;
	protected String tipoActuador;
	protected Mediator mediator; 
	
	public void setMediator(Mediator mediator )
	{
		this.mediator = mediator;
	}
	
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
