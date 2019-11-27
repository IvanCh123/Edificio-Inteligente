

import java.util.List;
import java.util.ArrayList;

import java.util.HashMap;

public class Mediator {
	
	private List<Sensor> sensores; 
	private List<Actuador> actuadores; 
	
	private HashMap<String, List<TratamientoComportamiento>> comportamientos;
	
	
	public Mediator()
	{
		this.sensores = new ArrayList<Sensor>(); 
		this.actuadores = new ArrayList<Actuador>();
		this.comportamientos = new HashMap<String,  List<TratamientoComportamiento>>();
	}
	
	public void setSensores(List<Sensor> sensores)
	{
		this.sensores.addAll(sensores);
	}
	
	public void setActuadores(List<Actuador> actuadores)
	{
		this.actuadores.addAll(actuadores);
	}
	
	public void addComportamiento(String commandNombre, TratamientoComportamiento command ){
		

		if ( this.comportamientos.get(commandNombre.toLowerCase()) == null)
		{
			this.comportamientos.put(commandNombre.toLowerCase(), new ArrayList<TratamientoComportamiento>());
			
		}
		this.comportamientos.get(commandNombre.toLowerCase()).add(command);
		
	}
	
	
	public void ejecutarComportamiento(String commandNombre){
		
		if(this.comportamientos.get(commandNombre.toLowerCase()) != null) {
		
			for(int index = 0; index < this.comportamientos.get(commandNombre.toLowerCase()).size(); ++index){
				this.comportamientos.get(commandNombre.toLowerCase()).get(index).ejecutar();		
			}
		}
	} 
}

	
