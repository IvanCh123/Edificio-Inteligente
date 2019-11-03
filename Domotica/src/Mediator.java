import java.util.List; 
import java.util.ArrayList;

import java.util.HashMap;

public class Mediator {
	
	private List<Sensor> sensores; 
	private List<Actuador> actuadores; 
	
	private HashMap<String, List<TratamientoComportamiento>> comportamientos;
	
	
	public Mediator()
	{
		sensores = new ArrayList<Sensor>(); 
		actuadores = new ArrayList<Actuador>();
		comportamientos = new HashMap<String,  List<TratamientoComportamiento>>();
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
		

		if ( comportamientos.get(commandNombre) == null)
		{
			comportamientos.put(commandNombre, new ArrayList<TratamientoComportamiento>());
			
		}
		comportamientos.get(commandNombre).add(command);
		
	}
	
	
	public void ejecutarComportamiento(String commandNombre){
		
		for(int index = 0; index < comportamientos.get(commandNombre).size(); ++index){
			comportamientos.get(commandNombre).get(index).ejecutar();		
			System.out.println(comportamientos.get(commandNombre).get(index).toString());
		}
	}
}

	
