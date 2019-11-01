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
		notify(this.tipoActuador);
	}
	
	public void apagar() {
		estado = false; 
		notify(this.tipoActuador);
	}
	
	public boolean getEstado() {
		return this.estado;
	}
	
	public void notify(String commandNombre){
		 mediator.ejecutarComportamiento(commandNombre);
	}
	
	protected abstract Actuador crearActuador();
}
