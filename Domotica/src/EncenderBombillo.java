public class EncenderBombillo implements TratamientoComportamiento {

	Actuador bombillo; 
	
	public EncenderBombillo( Actuador bombillo )
	{ 
		this.bombillo = bombillo; 
	}
	
	@Override
	public void ejecutar() {
		bombillo.encender();
 
	}
}
