public abstract class SensoresFactory {
	
	public Sensor crear()
	{
		Sensor sensor = crearSensor();
		
		return sensor;
	}
		
	public abstract Sensor crearSensor();
}
