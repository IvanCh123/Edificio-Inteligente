import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class Elevator implements InterfaceElevator{
	
	private int pisoActual;
	private int idElevator;
	private ElevatorDirection direccion;
	private ElevatorStatus estado;
	
	private TreeSet<Integer> pisosSobre; 
	private TreeSet<Integer> pisosDebajo; 
	
	public Elevator(int pisoActual, int idElevator){
		this.pisoActual = pisoActual;
		this.idElevator = idElevator;
		
		this.pisosSobre = new TreeSet<Integer>();
		this.pisosDebajo = new TreeSet<Integer>();
		
		this.estado = ElevatorStatus.ELEVATOR_EMPTY;
		this.direccion = ElevatorDirection.ELEVATOR_HOLD;
	}
	
    public boolean actualizarEstado(ElevatorStatus estado) 
    {
    	if( getTotalPedidos() > 0 )
    		return false;
    	
    	this.estado = estado;
    	return true;
    }
    
    public void addDestino(int destino)
    {
    	if(destino > this.pisoActual)
    		this.pisosSobre.add(destino);
    	else
    		this.pisosDebajo.add(destino);
    }

    public boolean moverElevador() 
    {
    	return true;
    }

    private boolean eliminarDestinoArriba()
    {
    	this.pisosSobre.remove(this.pisosSobre.first());
    	
    	if(this.pisosSobre.size() == 0)
    		this.direccion = ElevatorDirection.ELEVATOR_HOLD;
    	
    	return true;
    }
    
    private boolean eliminarDestinoAbajo()
    {
    	this.pisosDebajo.remove(this.pisosDebajo.first());
    	
    	if(this.pisosDebajo.size() == 0)
    		this.direccion = ElevatorDirection.ELEVATOR_HOLD;
    	
    	return true;
    	
    }
    
    public int getDestinoSiguiente()
    {
		if( this.direccion == ElevatorDirection.ELEVATOR_DOWN) 
		{
			return this.pisosDebajo.first();
		}else if (this.direccion == ElevatorDirection.ELEVATOR_UP)
		{
			return this.pisosSobre.first();
		}
		else
		{
			return 0;
		}
    }
    
    public int getTotalPedidos()
    {
    	return pisosSobre.size() + pisosDebajo.size();
    }
	
    public int getPisoActual()
    {
    	return this.pisoActual;
    }
    
    public ElevatorStatus getEstado()
    {
    	return this.estado;
    }
    
    public ElevatorDirection getDireccion()
    {
    	return this.direccion;
    }

    public int getID()
    {
    	return this.idElevator;
    }
	
}
