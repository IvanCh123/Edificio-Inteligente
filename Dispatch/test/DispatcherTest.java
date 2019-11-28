import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class DispatcherTest {
	
	@Test
	void testCrearElevadores() {
		System.out.println("\n----------------------");
		System.out.println("Crear Elevadores"); 
		 Elevator elevador = new Elevator.Builder()
						.setID(1)
						.setPisoActual(2)
						.build();
		 
		 assertEquals(elevador.getID(), 1);
		 assertEquals(elevador.getPisoActual(), 2);
	}

	@Test
	public void testAddPisos(){
		System.out.println("\n----------------------");
		System.out.println("Add pisos"); 
		Elevator elevador = new Elevator.Builder()
							.setID(1)
							.setPisoActual(2)
							.addPiso(3)
							.addPiso(4)
							.addPiso(1)
							.build();

		assertEquals(elevador.getTotalPedidos(), 3);
	}

	@Test
	public void testAlgoritmo()
	{
		System.out.println("\n----------------------");
		System.out.println("Test Algoritmo"); 
		Elevator elevador = new Elevator.Builder()
							.setID(1)
							.setPisoActual(2)
							.addPiso(3)
							.addPiso(4)
							.addPiso(1)
							.build();
		Elevator elevador2 = new Elevator.Builder()
							.setID(2)
							.setPisoActual(1)
							.addPiso(3)
							.addPiso(6)
							.addPiso(7)
							.build();

		Dispatcher dispatcher = new Dispatcher.Builder()
								.addElevador(elevador)
								.addElevador(elevador2)
								.setNumeroDePisos(10)
								.build();
											
								
		
		System.out.println("Asensores "+dispatcher.getElevadores());			
		System.out.println("Pedir "+dispatcher.pedirElevador(3));	
		
		assertEquals(dispatcher.pedirElevador(6),2);	
		
		System.out.println("*** Stepping simulation ***");
        while(dispatcher.getPedidos() > 0){
            dispatcher.step();
            for(Elevator elevator : dispatcher.getElevadores()){
                System.out.println("Elevator[" + elevator.getID() + "] - Current Floor " + elevator.getPisoActual());
            }
        }
	} 
	@Test
	public void tresElevadores()
	{
		System.out.println("\n----------------------");
		System.out.println("Tres elevadores"); 
    	Elevator elevador = new Elevator.Builder()
				.setID(1)
				.setPisoActual(2)
				.addPiso(3)
				.addPiso(4)
				.addPiso(1)
				.build();
    	
    	Elevator elevador2 = new Elevator.Builder()
				.setID(2)
				.setPisoActual(1)
				.addPiso(3)
				.addPiso(6)
				.addPiso(7)
				.build();
    	
    	Elevator elevador3 = new Elevator.Builder()
    			.setID(3)
    			.setPisoActual(4)
    			.addPiso(3)
    			.addPiso(4)
    			.addPiso(2)
    			.build();
    	
		Dispatcher dispatcher = new Dispatcher.Builder()
				.addElevador(elevador)
				.addElevador(elevador2)
				.addElevador(elevador3)
				.setNumeroDePisos(10)
				.build();
							
				

		System.out.println("Asensores "+dispatcher.getElevadores());			
		System.out.println("Pedir "+dispatcher.pedirElevador(3));	
		
		assertEquals(dispatcher.pedirElevador(3),1);	
		
		System.out.println("*** Stepping simulation ***");
		while(dispatcher.getPedidos() > 0){
			dispatcher.step();
			for(Elevator elevator : dispatcher.getElevadores()){
				System.out.println("Elevator[" + elevator.getID() + "] - Current Floor " + elevator.getPisoActual());
			}
		}
	}
    
    @Test
    public void elPisoNoEstaEnLosElevadores()
    {
		System.out.println("\n----------------------");
		System.out.println("El piso no esta en los elevadores"); 
    	Elevator elevador = new Elevator.Builder()
				.setID(1)
				.setPisoActual(4)
				.addPiso(10)
				.addPiso(2)
				.addPiso(4)
				.addPiso(7)
				.build(); 
    	
    	Elevator elevador2 = new Elevator.Builder()
				.setID(2)
				.setPisoActual(2)
				.addPiso(7)
				.addPiso(3)
				.addPiso(5)
				.addPiso(4)
				.build();
    	
    	Elevator elevador3 = new Elevator.Builder()
				.setID(3)
				.setPisoActual(3)
				.addPiso(8)
				.addPiso(0)
				.addPiso(4)
				.addPiso(7)
				.build();
    	

    	
		Dispatcher dispatcher = new Dispatcher.Builder()
				.addElevador(elevador)
				.addElevador(elevador2)
				.addElevador(elevador3)
				.setNumeroDePisos(10)
				.build();
		
		System.out.println("Asensores "+dispatcher.getElevadores());	
		if( dispatcher.pedirElevador(1) == -1)
			System.out.println("No hay un elevador disponible");
		else
			System.out.println("Pedir "+dispatcher.pedirElevador(1));	
		
		assertEquals(dispatcher.pedirElevador(1),-1);	
		
		System.out.println("*** Stepping simulation ***");
		while(dispatcher.getPedidos() > 0){
			dispatcher.step();
			for(Elevator elevator : dispatcher.getElevadores()){
				System.out.println("Elevator[" + elevator.getID() + "] - Current Floor " + elevator.getPisoActual());
			}
		}
    	
    }
    
   // @Test
    public void muchosElevadores()
    {
		System.out.println("\n----------------------");
		System.out.println("Muchos elevadores"); 
    	Elevator elevador = new Elevator.Builder()
				.setID(1)
				.setPisoActual(9)
				.addPiso(10)
				.addPiso(2)
				.addPiso(4)
				.addPiso(3)
				.build(); 
    	
    	Elevator elevador2 = new Elevator.Builder()
				.setID(2)
				.setPisoActual(7)
				.addPiso(7)
				.addPiso(3)
				.addPiso(5)
				.addPiso(4)
				.build();
    	
    	Elevator elevador3 = new Elevator.Builder()
				.setID(3)
				.setPisoActual(4)
				.addPiso(8)
				.addPiso(0)
				.addPiso(4)
				.addPiso(9)
				.build();
    	Elevator elevador4 = new Elevator.Builder()
				.setID(3)
				.setPisoActual(8)
				.addPiso(8)
				.addPiso(0)
				.addPiso(4)
				.addPiso(7)
				.build();
    	
		Dispatcher dispatcher = new Dispatcher.Builder()
				.addElevador(elevador)
				.addElevador(elevador2)
				.addElevador(elevador3)
				.addElevador(elevador4)
				.setNumeroDePisos(10)
				.build();
		
		System.out.println("Asensores "+dispatcher.getElevadores());			
		System.out.println("Pedir "+dispatcher.pedirElevador(3));	
		
		assertEquals(dispatcher.pedirElevador(3),2);	
		
		System.out.println("*** Stepping simulation ***");
		while(dispatcher.getPedidos() > 0){
			dispatcher.step();
			for(Elevator elevator : dispatcher.getElevadores()){
				System.out.println("Elevator[" + elevator.getID() + "] - Current Floor " + elevator.getPisoActual());
			}
		}
    }
}
