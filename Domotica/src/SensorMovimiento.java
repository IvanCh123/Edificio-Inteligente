

public class SensorMovimiento extends Sensor{
	
	boolean movimiento;
	
	protected Sensor crearSensor() 
	{
		return new SensorMovimiento(); 
	}
	
	public SensorMovimiento()
	{
		this.tipoSensor = "Movimiento";
	}
	
	public void setMovimiento(boolean movimiento) {
		this.movimiento = movimiento;
		this.notify(this.tipoSensor); 
	}
	
	public boolean getMovimiento() {
		return this.movimiento;
	}
}
