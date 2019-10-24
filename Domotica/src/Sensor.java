
public abstract class Sensor {

	protected String posicion; 
	protected String tipoSensor;
	protected boolean estado;
	
	
	public boolean getEstado() {
		return this.estado;
	}
	
	public String getInfo(){
		return "Posicion: "+this.posicion+"Tipo: "+this.tipoSensor+"Estado: "+Boolean.toString(this.estado)+"\n";
	}
	
	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
	
	public void setTipo(String tipo) {
		this.tipoSensor = tipo;
	}
	
}
