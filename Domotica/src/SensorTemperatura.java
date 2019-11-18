

public class SensorTemperatura extends Sensor{
	
	float temperatura;
	
	protected Sensor crearSensor() 
	{
		return new SensorTemperatura();
	}
	
	public SensorTemperatura()
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
