public class EncenderAire implements TratamientoComportamiento {

	Actuador aire; 
	
	public EncenderAire( Actuador aire )
	{ 
		this.aire = aire; 
	}
	
	@Override
	public void ejecutar() {
		System.out.println("Se encendió el aire");
		aire.apagar();

	}
	
	@Override
	public String toString()
	{
		return "EncenderAire";
	}
}