import java.util.ArrayList;

public class CamarasComposite implements Camara {
	
	ArrayList<Camara> camaras;
	int id;
	
	public CamarasComposite() {
		this.camaras = new ArrayList<Camara>();
	}

	@Override
	public void agregarVisualizado(int id) {
		for(int i = 0; i < camaras.size(); ++i) {
			camaras.get(i).agregarVisualizado(id);
		}
	}

	@Override
	public void eliminarVisualizado(int id) {
		for(int i = 0; i < camaras.size(); ++i) {
			camaras.get(i).eliminarVisualizado(id);
		}
	}

	@Override
	public void rotarIzquierda() {
		for(int i = 0; i < camaras.size(); ++i) {
			camaras.get(i).rotarIzquierda();
		}
	}

	@Override
	public void rotarDerecha() {
		for(int i = 0; i < camaras.size(); ++i) {
			camaras.get(i).rotarDerecha();
		}
	}
	
	@Override
	public String getEstado() {
		String estado = "";
		for(int i = 0; i < camaras.size(); ++i) {
			estado = estado.concat(camaras.get(i).getEstado());
			estado = estado.concat("\n");
		}
		return estado;
	}
	
	@Override
	public Camara buscarVisualizado(int id) {
		Camara camara = null;
		for(int i = 0; i < camaras.size() && camara == null; ++i) {
			camara = camaras.get(i).buscarVisualizado(id);
		}
		return camara;
	}
	
	public void agregar(Camara camara) {
		this.camaras.add(camara);
	}
	
	public void eliminar(Camara camara) {
		this.camaras.remove(camara);
	}

}
