import java.util.List; 
import java.util.HashMap;

public class Mediator {
	
	private List<Sensor> sensores; 
	private List<Actuador> actuadores; 
	private HashMap<String, List<TramientoComportamiento>> comportamientos;
	
	private boolean senal; 
	
	
	public void setSensores(List<Sensor> sensores)
	{
		this.sensores.addAll(sensores);
	}
	
	public void setActuadores(List<Actuador> actuadores)
	{
		this.actuadores.addAll(actuadores);
	}
	
	public void addComportamiento(String commandNombre, TramientoComportamiento command ){
		
		// crear lista y agregar el comportamiento a la lista para poder agregar al mapa
		// comportamientos.add(commandNombre, command);		
	}
	
	public void setSenal(boolean senal)
	{
		this.senal = senal; 
	}
	
	public boolean getSenal() {
		return this.senal; 
	}
	
	public void ejecutarComportamiento(String commandNombre){
		
		if( this.getSenal() == true)
		{
			for(int index = 0; index <comportamientos.get(commandNombre).size(); ++index){
				// Recorrer y ejecutar
			}
		}

	}
}

	
