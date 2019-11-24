public class SensorShock extends Sensor{
	
	protected Sensor crearSensor() 
	{
		return new SensorShock();
	}
	
	public SensorShock()
	{
		this.tipoSensor = "Shock";
	}
}
