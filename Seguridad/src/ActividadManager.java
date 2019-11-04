import java.util.HashMap;
import java.util.Map;

public class ActividadManager{
	
	private HashMap<String, ActividadListener> listeners = new HashMap<String, ActividadListener>();
	
	public void suscribir(String evento, ActividadListener listener) {
		this.listeners.put(evento, listener);  // El log se suscribe con evento  = "Acceso"
	}
	
	public void cancelarSuscripcion(String evento, ActividadListener listener) {
		this.listeners.remove(evento, listener);
	}
	
	public void notificar(String evento, String tipo, int id) {
		for (Map.Entry<String, ActividadListener> me : this.listeners.entrySet()) {
			if(me.getKey() == evento) {
				me.getValue().update(tipo, id);
			}
	    }
	}
	
}