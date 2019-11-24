

public abstract class Actuador {

	protected boolean estado;
	protected String tipoActuador;
	protected Mediator mediator; 
	
	public void setMediator(Mediator mediator )
	{
		this.mediator = mediator;
	}
	
	public void setTipoActuador(String tipoActuador) 
	{
		this.tipoActuador = tipoActuador;
	}
	
	public void encender(){
		this.estado = true;
		System.out.println("Se enciende "+this.tipoActuador);
		notify(this.tipoActuador + " encender");
	}
	
	public void apagar() {
		this.estado = false; 
		System.out.println("Se apaga "+this.tipoActuador);
		notify(this.tipoActuador + " apagar");
	}
	
	public boolean getEstado() {
		return this.estado;
	}
	
	public void notify(String commandNombre){
		 mediator.ejecutarComportamiento(commandNombre.toLowerCase());
	}
	
	protected abstract Actuador crearActuador();
} 
