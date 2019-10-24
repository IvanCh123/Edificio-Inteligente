import java.util.ArrayList;
import java.lang.Math;

public class Camara {
	
	final String DIRECCIONES[] = {"la izquierda", "el centro", "la derecha"};
	int posicion[]= new int[2];
	ArrayList<Integer> ids = new ArrayList<Integer>();
	int direccion;
	
	private String getEstado() {
		return "Cámara en torre " + getTorre() + ", piso " + getPiso() + " apuntando hacia " + getDireccion();
	}
	
	private int getTorre() {
		return this.posicion[0];
	}
	
	private int getPiso() {
		return this.posicion[1];
	}
	
	private String getDireccion() {
		return this.DIRECCIONES[this.direccion];
	}
	
	private void setTorre(int torre) {
		this.posicion[0] = torre;
	}
	
	private void setPiso(int piso) {
		this.posicion[1] = piso;
	}
	
	private void setDireccion(int direccion) {
		this.direccion = direccion;
	}
	
	private void rotarIzquierda() {
		this.direccion = Math.abs(--this.direccion)%3;
	}
	
	private void rotarDerecha() {
		this.direccion = ++this.direccion%3;
	}
	
	private void agregarPersonas(int id) {
		this.ids.add(id);
	}
	
	private void removerPersona(int id) {
		this.ids.remove(id);
	}
}
