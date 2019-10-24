
public abstract class ActuadoresFactory {

	
	public Actuador crear()
	{
		Actuador actuador = crearActuador();
		
		return actuador;
		
	}
		
	public abstract Actuador crearActuador();
}
