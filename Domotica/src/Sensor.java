
public abstract class Sensor {
 
	protected String tipoSensor;
	protected boolean estado;
	
	protected Mediator mediator; 
	
	public void setMediator(Mediator mediator )
	{
		this.mediator = mediator;
	}
	
	public boolean getEstado() {
		return this.estado;
	}
	
	public void setEstado(boolean estado)
	{
		this.estado = estado;
		if(estado)
			this.notify("Hay " + this.tipoSensor);
		else
			this.notify("No hay "+ this.tipoSensor);
	}
	
	public String toString(){
		return "Tipo: " + this.tipoSensor + "Estado: " + Boolean.toString(this.estado) + "\n";
	}
	
	public void setTipo(String tipo) {
		this.tipoSensor = tipo;
	}
	
	public void notify(String commandNombre){
		 mediator.ejecutarComportamiento(commandNombre);
	}
	
}
