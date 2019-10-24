
public class Sonido extends Sensor{
	boolean sonido;
	
	protected Sensor crearSensor() 
	{
		return new Sonido();
	}
	
	public Sonido()
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
