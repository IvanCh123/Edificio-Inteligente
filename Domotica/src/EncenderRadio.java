public class EncenderRadio implements TratamientoComportamiento{

	Actuador radio; 
	
	public EncenderRadio( Actuador radio )
	{ 
		this.radio = radio; 
	}
	
	@Override
	public void ejecutar() {
		radio.encender();

	}
}
