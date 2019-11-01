
public abstract class Sensor {

	protected String posicion; 
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
	}
	
	public String getInfo(){
		return "Posicion: "+this.posicion+"Tipo: "+this.tipoSensor+"Estado: "+Boolean.toString(this.estado)+"\n";
	}
	
	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
	
	public void setTipo(String tipo) {
		this.tipoSensor = tipo;
	}
	
	public void notify(String commandNombre){
		 mediator.ejecutarComportamiento(commandNombre);
	}
	
}
