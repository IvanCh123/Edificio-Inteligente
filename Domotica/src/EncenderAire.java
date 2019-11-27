public class EncenderAire implements TratamientoComportamiento {

	Actuador aire; 
	
	public EncenderAire( Actuador aire )
	{ 
		this.aire = aire; 
	}
	
	@Override
	public void ejecutar() {
		aire.encender();

	}
}