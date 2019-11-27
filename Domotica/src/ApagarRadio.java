public class ApagarRadio implements TratamientoComportamiento{

	Actuador radio; 
	
	public ApagarRadio( Actuador radio )
	{ 
		this.radio = radio; 
	}
	
	@Override
	public void ejecutar() {
		radio.apagar(); 

	}
}
