

public class SensorShock extends Sensor{

	boolean vibracion;
	
	protected Sensor crearSensor() 
	{
		return new SensorShock();
	}
	
	public SensorShock()
	{
		this.tipoSensor = "Shock";
	}
	
	public void setVibracion(boolean vibracion) {
		this.vibracion = vibracion;
	}
	
	public boolean getVibracion() {
		return this.vibracion;
	}
	
}
