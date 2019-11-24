

public abstract class Sensor {
 
	protected String tipoSensor;
	protected boolean estado;
	
	protected Mediator mediator; 
	
	public void setMediator(Mediator mediator )
	{
		this.mediator = mediator;
	}
	
	public boolean getEstado() 
	{
		return this.estado;
	}
	
	public void setEstado(boolean estado)
	{
		this.estado = estado;
		if(this.estado) 
		{
			System.out.println("Hay "+this.tipoSensor);
			this.notify("Hay " + this.tipoSensor);
		}
		else
		{
			System.out.println("No hay "+this.tipoSensor);
			this.notify("No hay "+ this.tipoSensor); 
		}
	}
	
	public void setTipoSensor(String tipo) {
		this.tipoSensor = tipo;
	}
	
	public String getTipoSensor() 
	{
		return this.tipoSensor; 
	}
	
	public void notify(String commandNombre){
		 mediator.ejecutarComportamiento(commandNombre);
	}
}
