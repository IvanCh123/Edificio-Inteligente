import java.util.ArrayList;

public class CamarasComposite implements Camara {
	
	ArrayList<Camara> camaras;
	
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
	
	public void agregar(Camara camara) {
		this.camaras.add(camara);
	}
	
	public void eliminar(Camara camara) {
		this.camaras.remove(camara);
	}

}
