public class ApagarBombillo implements TratamientoComportamiento {

	Actuador bombillo; 
	
	public ApagarBombillo( Actuador bombillo )
	{ 
		this.bombillo = bombillo; 
	}
	
	@Override
	public void ejecutar() {
		bombillo.apagar();
 
	}
}
