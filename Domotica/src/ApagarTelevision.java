public class ApagarTelevision implements TratamientoComportamiento{
	Actuador television; 
	
	public ApagarTelevision( Actuador television )
	{ 
		this.television = television; 
	}
	
	@Override
	public void ejecutar() {
		System.out.println("Se apagó la televisión");
		television.apagar();

	}
	
	@Override
	public String toString()
	{
		return "ApagarTelevision";
	}
}
