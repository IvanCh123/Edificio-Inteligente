import java.lang.Math;

public class CamaraPasillos implements Camara {
	
	final String DIRECCIONES[] = {"Izquierda", "Centro", "Derecha"};
	int ubicacion[];
	int direccion;
	
	public CamaraPasillos(int direccion) {
		this.ubicacion = new int[2];
		this.direccion = direccion;
	}
	
	@Override
	public void agregarVisualizado(int id) {
		visualizados.add(id); 
	}

	@Override
	public void eliminarVisualizado(int id) {
		visualizados.remove(id);
	}
	
	@Override
	public void rotarIzquierda() {
		this.direccion = Math.abs(this.direccion--)%(DIRECCIONES.length);
	}
	
	@Override
	public void rotarDerecha() {
		this.direccion = (this.direccion++)%(DIRECCIONES.length);
	}
	
	@Override
	public String getEstado() {
		return "Camara:\n\tTorre: " + ubicacion[0] + "\n\tPiso: " + ubicacion[1] + "\n\tDireccion: " + this.DIRECCIONES[this.direccion];
	}
	
	@Override
	public Camara buscarVisualizado(int id) {
		for(int i = 0; i < visualizados.size(); ++i) {
			if(visualizados.get(i) == id)
				return this;
		}
		return null;
	}

	public void setTorre(int torre) {
		this.ubicacion[0] = torre;
	}

	public void setPiso(int piso) {
		this.ubicacion[1] = piso;
	}

	public void setDireccion(int direccion) {
		this.direccion = direccion;
	}

}
