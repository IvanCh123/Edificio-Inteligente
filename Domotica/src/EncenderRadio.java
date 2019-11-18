public class EncenderRadio implements TratamientoComportamiento{

	Actuador radio; 
	
	public EncenderRadio( Actuador radio )
	{ 
		this.radio = radio; 
	}
	
	@Override
	public void ejecutar() {
		System.out.println("Se encendió el radio");
		radio.encender();

	}
	
	@Override
	public String toString()
	{
		return "EncenderRadio";
	}
}
