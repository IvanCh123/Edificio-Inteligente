
public class Temperatura extends Sensor{
	
	float temperatura;
	
	protected Sensor crearSensor() 
	{
		return new Temperatura();
	}
	
	public Temperatura()
	{
		this.tipoSensor = "Temperatura"; 
	}
	
	public void setTemperatura(float temperatura) {
		this.temperatura = temperatura;
		
	}
	
	public float getTemperatura() {
		return this.temperatura;
	}
}
