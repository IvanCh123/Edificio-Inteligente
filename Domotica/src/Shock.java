
public class Shock extends Sensor{

	boolean vibracion;
	
	protected Sensor crearSensor() 
	{
		return new Shock();
	}
	
	public Shock()
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
