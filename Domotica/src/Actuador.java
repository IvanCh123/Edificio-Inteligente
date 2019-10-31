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
		
		ejecutar(this.tipoActuador);
	}
	
	public void apagar() {
		estado = false; 
	}
	
	public boolean getEstado() {
		return this.estado;
	}
	
	public void ejecutar(String commandNombre){
		 mediator.ejecutarComportamiento(commandNombre);
	}
	
	protected abstract Actuador crearActuador();
}
