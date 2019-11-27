public abstract class ActuadoresFactory {

	public Actuador crear()
	{
		Actuador actuador = crearActuador();
		
		return actuador;
		
	}
		
	protected abstract Actuador crearActuador();
}
