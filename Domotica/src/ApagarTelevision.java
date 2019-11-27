public class ApagarTelevision implements TratamientoComportamiento{
	Actuador television; 
	
	public ApagarTelevision( Actuador television )
	{ 
		this.television = television; 
	}
	
	@Override
	public void ejecutar() {
		television.apagar();

	}
}
