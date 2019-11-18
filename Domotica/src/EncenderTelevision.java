public class EncenderTelevision implements TratamientoComportamiento{
	Actuador television; 
	
	public EncenderTelevision( Actuador television )
	{ 
		this.television = television; 
	}
	
	@Override
	public void ejecutar() {
		System.out.println("Se encendió la televisión");
		television.encender();

	}
	
	@Override
	public String toString()
	{
		return "EncenderTelevision";
	}
}
