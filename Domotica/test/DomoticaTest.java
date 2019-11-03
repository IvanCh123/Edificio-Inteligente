import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DomoticaTest{
	
	@Test
	public void hayMovimientoEncenderBombilloTest(){
	
		Mediator mediator = new Mediator(); 
		
		Sensor movimiento = new Movimiento(); 
		Actuador bombillo = new Bombillo(); 
		movimiento.setMediator(mediator);
		bombillo.setMediator(mediator);
		
		List<Sensor> sensores = new ArrayList<Sensor>(); 
		List<Actuador> actuadores = new ArrayList<Actuador>(); 
		
		
		sensores.add(movimiento); 
		actuadores.add(bombillo); 
		
		mediator.setActuadores(actuadores);
		mediator.setSensores(sensores);
		
		mediator.addComportamiento("Movimiento", new EncenderBombillo(bombillo));
		
		movimiento.setEstado(true); 
		
		assertEquals(bombillo.getEstado(), true);
		
	}
}
