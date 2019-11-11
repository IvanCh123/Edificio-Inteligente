
public class EncenderBombillo implements TratamientoComportamiento {

	Actuador bombillo; 
	
	public EncenderBombillo( Actuador bombillo )
	{ 
		this.bombillo = bombillo; 
	}
	
	@Override
	public void ejecutar() {
		System.out.println("Se prendió el bombillo");
		bombillo.encender();

	}
	
	@Override
	public String toString()
	{
		return "EncenderBombillo";
	}
}
