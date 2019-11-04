import java.util.HashMap;
import java.util.Map;

public class ActividadManager{
	
	private HashMap<String, ActividadListener> observers = new HashMap<String, ActividadListener>();
	
	public void suscribir(String evento, ActividadListener observer) {
		this.observers.put(evento, observer);  // El log se suscribe con evento  = "Acceso"
	}
	
	public void cancelarSuscripcion(String evento, ActividadListener observer) {
		this.observers.remove(evento, observer);
	}
	
	public void notificar(String evento, String tipo, int id) {
		for (Map.Entry<String, ActividadListener> me : this.observers.entrySet()) {
			if(me.getKey().equals(evento)) {
				me.getValue().update(tipo, id);
			}
	    }
	}
	
}