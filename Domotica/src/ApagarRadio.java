public class ApagarRadio implements TratamientoComportamiento{

	Actuador radio; 
	
	public ApagarRadio( Actuador radio )
	{ 
		this.radio = radio; 
	}
	
	@Override
	public void ejecutar() {
		System.out.println("Se apagó el radio");
		radio.apagar();

	}
	
	@Override
	public String toString()
	{
		return "ApagarRadio";
	}
}
