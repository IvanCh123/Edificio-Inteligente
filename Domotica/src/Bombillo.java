

public class Bombillo extends Actuador{
	
	String color;
	
	protected Actuador crearActuador() 
	{
		return new Bombillo();
	}
	
	public Bombillo() 
	{
		this.tipoActuador = "Bombillo";
	} 
	
	public void cambiarColor(String color){ 
		this.color = color; 
		System.out.println("Se cambia el color del bombillo a "+this.color);
		this.notify( ("Color cambia "+this.color).toLowerCase() );
	} 
	
	public String getColor() {
		return this.color; 
	}
	
}
