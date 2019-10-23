
public class Sensor {

	String posicion; 
	String tipo;
	int estado;
	
	public Sensor(String posicion, String tipo, int estado){
		this.posicion = posicion;
		this.tipo = tipo;
		this.estado = estado;
	}
		
	public int getEstado() {
		return this.estado;
	}
	
	public String getInfo(){
		return "";
	}
	
}
