
public class ApagarAire implements TratamientoComportamiento {

	Actuador aire; 
	
	public ApagarAire( Actuador aire )
	{ 
		this.aire = aire; 
	}
	
	@Override
	public void ejecutar() {
		aire.apagar();

	} 
}