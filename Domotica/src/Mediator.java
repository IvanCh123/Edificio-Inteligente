import java.util.List; 
import java.util.LinkedHashMap;

public class Mediator {
	
	private List<Sensor> sensores; 
	private List<Actuador> actuadores; 
	private LinkedHashMap<String, TramientoComportamiento> comportamientos;
	
	
	public void setSensores(List<Sensor> sensores)
	{
		this.sensores.addAll(sensores);
	}
	
	public void setActuadores(List<Actuador> actuadores)
	{
		this.actuadores.addAll(actuadores);
	}
	
	public void addComportamiento(String commandNombre, TramientoComportamiento command ){
		
		comportamientos.put(commandNombre, command);		
	}
	
	public void ejecutarComportamiento(String commandNombre){
		for(int i=0;i<comportamientos.size();i++){
			// Recorrer y ejecutar
		}
	}
}

	
