
public class Bombillo {
	
	boolean estado; 
	String color;
	
	public Bombillo(String color) {
		this.color = color; 
	}
	
	public void encender(){
		this.estado = true; 
	}
	
	public void apagar() {
		this.estado = false; 
	}
	
	public void cambiarColor(String color){
		this.color = color; 
	}
	
	public String getColor() {
		return this.color; 
	}
	
	public boolean getEstado() {
		return this.estado;
	}
}
