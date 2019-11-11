
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
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public String getColor() {
		return this.color; 
	}
	
}
