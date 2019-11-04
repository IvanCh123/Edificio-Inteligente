public class ApagarAire implements TratamientoComportamiento {

	Actuador aire; 
	
	public ApagarAire( Actuador aire )
	{ 
		this.aire = aire; 
	}
	
	@Override
	public void ejecutar() {
		System.out.println("Se apago el aire");
		aire.apagar();

	}
	
	@Override
	public String toString()
	{
		return "ApagarAire";
	}
}