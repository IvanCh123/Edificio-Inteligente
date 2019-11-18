

public abstract class Actuador {

	protected boolean estado;
	protected String tipoActuador;
	protected Mediator mediator; 
	
	public void setMediator(Mediator mediator )
	{
		this.mediator = mediator;
	}
	
	public void encender(){
		this.estado = true;	
		notify(this.tipoActuador + " encender");
	}
	
	public void apagar() {
		this.estado = false; 
		notify(this.tipoActuador + " apagar");
	}
	
	public boolean getEstado() {
		return this.estado;
	}
	
	public void notify(String commandNombre){
		 mediator.ejecutarComportamiento(commandNombre);
	}
	
	protected abstract Actuador crearActuador();
}
