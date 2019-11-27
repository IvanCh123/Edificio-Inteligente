public class EncenderTelevision implements TratamientoComportamiento{
	Actuador television; 
	
	public EncenderTelevision( Actuador television )
	{ 
		this.television = television; 
	}
	
	@Override
	public void ejecutar() {
		television.encender();

	}
} 
