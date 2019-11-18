
public class CambiarColorBombillo implements TratamientoComportamiento {

	Actuador bombillo; 
	
	String color;
	
	public CambiarColorBombillo( Actuador bombillo, String color )
	{ 
		this.bombillo = bombillo; 	
		this.color = color;
	}
	
	@Override
	public void ejecutar() {
		System.out.println("Se cambió el color del bombillo "+this.color);
		((Bombillo)bombillo).cambiarColor(this.color);

	}
	
	@Override
	public String toString()
	{
		return "CambiarColor";
	}
}
