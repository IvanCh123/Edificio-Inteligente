public class ApagarBombillo implements TratamientoComportamiento {

	Actuador bombillo; 
	
	public ApagarBombillo( Actuador bombillo )
	{ 
		this.bombillo = bombillo; 
	}
	
	@Override
	public void ejecutar() {
		System.out.println("Se apagó el bombillo");
		bombillo.apagar();

	}
	
	@Override
	public String toString()
	{
		return "EncenderBombillo";
	}
}
