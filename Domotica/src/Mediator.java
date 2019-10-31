import java.util.List; 
import java.util.LinkedHashMap;

public class Mediator {
	
	private List<Sensor> sensores; 
	private List<Actuador> actuadores; 
	private LinkedHashMap<Sensor,Actuador> comportamientos;
	
	
	public void setSensores(List<Sensor> sensores)
	{
		this.sensores.addAll(sensores);
	}
	
	public void setActuadores(List<Actuador> actuadores)
	{
		this.actuadores.addAll(actuadores);
	}
	
	public void addBehaviorMethod(/*Sensor.Method, Actuador.Method*/){	
		
	}
	
	public void addBehaviorParameter(/*Sensor.Param, Actuador.Method*/) {
		
	}
	
	
}
