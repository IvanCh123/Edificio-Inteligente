import java.util.*; 

public class Dispatcher {

	private final int delayEntre = 5;
	private final int delayParada = 10;

	private int pedidos = 0;
	public Hashtable<ElevatorType, List<Integer>> tablaDatos;
	public int numeroDePisos;  
	public List<Elevator> elevadores; 
	

	public Dispatcher() {
		elevadores = new ArrayList<Elevator>(); 
	}
	
	public static class Builder
	{
		private Dispatcher edificio; 
		
		public Builder()
		{
			this.edificio = new Dispatcher(); 
		}
		
		public Builder addElevador(Elevator elevator){
			this.edificio.elevadores.add(elevator); 
			return this;
		}
		
		public Builder setNumeroDePisos(int numeroDePisos)
		{
			this.edificio.numeroDePisos = numeroDePisos; 
			return this;
		}
		
		public Builder setElevadores(List<Elevator> elevadores)
		{
			this.edificio.elevadores.addAll(elevadores); 
			return this; 
		}

		public Builder addFloor(ElevatorType tipoElevador, int piso) {
			List<Integer> listaPisos = this.edificio.tablaDatos.get(tipoElevador);
			
			if(listaPisos == null) { // Si este tipo de elevador no tiene pisos
				listaPisos = new ArrayList<Integer>();
			}
			
			if(listaPisos.contains(piso)) { // Si ese tipo de elevador ya tiene ese piso
				return this;
			}
			
			listaPisos.add(piso);
			this.edificio.tablaDatos.put(tipoElevador, listaPisos);
			return this;
		}
		
		public Dispatcher build()
		{
			return this.edificio; 
		}
	}


	public void step() {
        for (Elevator currElevator : this.elevadores) {
            if(currElevator.moverElevador()){
                this.pedidos--;
            }
        }
    }

	private int calcularTiempoLlegada(Elevator elevador, int destino)
	{
		int cantidadPisosRecorrer = Math.abs( elevador.pisoActual - destino );
		int cantidadParadas = 0;

		if( elevador.pisoActual < destino)
			cantidadParadas = elevador.pisosSobre.size();
		else if( elevador.pisoActual > destino)
			cantidadParadas = elevador.pisosDebajo.size();
		else
			return 0;
		int espera = (cantidadPisosRecorrer * this.delayEntre) + (cantidadParadas * this.delayParada);
		return espera;
	}		

	public int pedirElevador(int destino) {
		
		int idEscogido = -1;
		int tiempoMinimo = -1;
		Iterator<Elevator> iterator = this.elevadores.iterator();
		
		while( iterator.hasNext() ) 
		{
			Elevator temp = iterator.next();

			boolean estoyQuedito = (temp.getDireccion() ==  ElevatorDirection.ELEVATOR_HOLD);
			boolean voySubida = ( (temp.getDireccion() ==  ElevatorDirection.ELEVATOR_UP) && (temp.getPisoActual() < destino));
			boolean voyBajada = ( (temp.getDireccion() ==  ElevatorDirection.ELEVATOR_DOWN) && (temp.getPisoActual() > destino));
			if( estoyQuedito || voySubida || voyBajada )
			{
				int tiempoTemporal = calcularTiempoLlegada(temp,destino);
				if( (tiempoTemporal < tiempoMinimo) || (tiempoMinimo == -1) )
				{
					tiempoMinimo = tiempoTemporal;
					idEscogido = temp.getID();
				}
			}
		}
		this.pedidos++;
		return idEscogido;
	}

	public List<Elevator> getElevadores(){
		return this.elevadores; 
	}

	public int getPedidos()
	{
		return this.pedidos;
	}

}
