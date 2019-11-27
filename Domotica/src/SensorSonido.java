

public class SensorSonido extends Sensor{
	protected Sensor crearSensor() 
	{
		return new SensorSonido();
	}
	
	public SensorSonido()
	{
		this.tipoSensor = "Sonido"; 
	}
}
