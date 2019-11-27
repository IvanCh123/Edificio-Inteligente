
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
		((Bombillo)bombillo).cambiarColor(this.color);
 
	}
}
