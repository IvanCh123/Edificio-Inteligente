

public class Television extends Actuador{

	protected Actuador crearActuador() 
	{
		return new Television();
	}
	
	public Television()
	{
		this.tipoActuador = "Television";
	}
} 
