import java.util.HashMap;

public class ActividadManager{
	
	private HashMap<String, ActividadListener> listeners = new HashMap<String, ActividadListener>();
	
	public void suscribir(String evento, ActividadListener listener) {
		listeners.put(evento, listener);
	}
	
	public void cancelarSuscripcion(String evento, ActividadListener listener) {
		listeners.remove(evento, listener);
	}
	
	public void notificar(String evento, int id) {
		
	}
	
}