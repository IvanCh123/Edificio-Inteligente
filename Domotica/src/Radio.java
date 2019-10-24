
public class Radio extends Actuador{
	protected Actuador crearActuador() 
	{
		return new Radio();
	}
	
	public Radio() 
	{
		this.tipoActuador = "Radio";
	}
	
}
