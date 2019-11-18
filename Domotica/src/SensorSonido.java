

public class SensorSonido extends Sensor{
	boolean sonido;
	
	protected Sensor crearSensor() 
	{
		return new SensorSonido();
	}
	
	public SensorSonido()
	{
		this.tipoSensor = "Sonido"; 
	}
	
	public void setSonido(boolean sonido) {
		this.sonido = sonido;
	}
	
	public boolean getSonido() {
		return this.sonido;
	}
}
