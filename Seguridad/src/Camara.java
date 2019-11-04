import java.util.ArrayList;

public interface Camara {

	ArrayList<Integer> visualizados = new ArrayList<Integer>();
	
	void agregarVisualizado(int id);
	void eliminarVisualizado(int id);
	Camara buscarVisualizado(int id);
	void rotarIzquierda();
	void rotarDerecha();
	String getEstado();
	void setEstado(int posiciones[]);
	
}
