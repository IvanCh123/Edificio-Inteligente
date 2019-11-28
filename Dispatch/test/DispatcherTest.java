import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DispatcherTest {

	@Test
	void testCrearElevadores() {
		 Elevator elevador = new Elevator.Builder()
						.setID(1)
						.setPisoActual(2)
						.build();
		 
		 assertEquals(elevador.getID(), 1);
		 assertEquals(elevador.getPisoActual(), 2);
	}

	@Test
	public void testAddPisos(){
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
								.setNumeroDePisos(10)
								.build();
											
								
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
}
