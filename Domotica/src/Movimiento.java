
public class Movimiento extends Sensor{
	boolean movimiento;
	
	protected Sensor crearSensor() 
	{
		return new Movimiento();
	}
	
	public Movimiento()
	{
		this.tipoSensor = "Movimiento";
	}
	
	public void setMovimiento(boolean movimiento) {
		this.movimiento = movimiento;
	}
	
	public boolean getMovimiento() {
		return this.movimiento;
	}
}
