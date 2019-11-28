import java.util.*;
import java.util.Comparator;
public class Elevator{
	
	public int pisoActual;
	public int idElevator;
	public ElevatorDirection direccion;
	public ElevatorType estado;
	
	public TreeSet<Integer> pisosSobre; 
	public TreeSet<Integer> pisosDebajo; 
	
	public Elevator(){		
		this.estado = ElevatorType.ELEVATOR_NORMAL;
		this.direccion = ElevatorDirection.ELEVATOR_HOLD;
		
		this.pisosSobre = new TreeSet<Integer>();
		this.pisosDebajo = new TreeSet<Integer>(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
		});
	}
	
	public String toString()
	{
		return "Id: " + this.idElevator;
	}
	
    public boolean actualizarEstado(ElevatorType estado) 
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
	
	public static class Builder
	{
		private Elevator elevator;

		public Builder()
		{
			this.elevator = new Elevator();
		}

		public Builder setPisoActual(int pisoActual) {
			this.elevator.pisoActual = pisoActual;
			return this;
		}
		
		public Builder setID(int id) 
		{
			this.elevator.idElevator = id;
			return this;
		}
		
		public Builder addPiso(int destino) 
		{
			if(destino > this.elevator.pisoActual)
    			this.elevator.pisosSobre.add(destino);
    		else
				this.elevator.pisosDebajo.add(destino);
			
			return this;
		}

		public Builder setEstado(ElevatorType estado) {
			this.elevator.estado = estado;
			return this;
		}

		public Builder setDireccion(ElevatorDirection direccion) {
			this.elevator.direccion = direccion; 
			return this;
		}
		
		public Elevator build() {
			return this.elevator;
		}

	}

	public boolean moverElevador() {
        direction();
        if(this.direccion == ElevatorDirection.ELEVATOR_UP){
            if(this.pisosSobre.first() == this.pisoActual){
                return eliminarDestinoArriba();
            }else {
                this.pisoActual++;
            }
        }else if(this.direccion == ElevatorDirection.ELEVATOR_DOWN){
            if(this.pisosDebajo.first() == this.pisoActual){
                return eliminarDestinoAbajo();
            }else {
                this.pisoActual--;
            }
		}
		
        return false;
    }

	private void direction() {
        if(this.direccion == ElevatorDirection.ELEVATOR_HOLD){
            if(this.pisosSobre.size() > 0 && this.pisosDebajo.size() > 0){
                if(Math.abs(this.pisoActual - this.pisosSobre.first()) < Math.abs(this.pisoActual - this.pisosDebajo.first())){
                    this.direccion = ElevatorDirection.ELEVATOR_UP;
                }else{
                    this.direccion = ElevatorDirection.ELEVATOR_DOWN;
                }
            }else if(this.pisosSobre.size() > 0){
                this.direccion = ElevatorDirection.ELEVATOR_UP;
            }else if(this.pisosDebajo.size() > 0){
                this.direccion = ElevatorDirection.ELEVATOR_DOWN;
            }
        }
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
    
    public ElevatorType getEstado()
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
