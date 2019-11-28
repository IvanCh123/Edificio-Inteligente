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

		Dispatcher dispatcher = new Dispatcher.Builder()
								.addElevador(elevador)
								.setNumeroDePisos(10);
								
								
		dispatcher.pedirElevador(3);	
		
		System.out.println("*** Stepping simulation ***");
        while(dispatcher.getPedidos() > 0){
            dispatcher.step();
            for(Elevator elevator : dispatcher.getElevadores()){
                System.out.println("Elevator[" + elevator.getID() + "] - Current Floor " + elevator.getPisoActual());
            }
        }

		
	} 
}
