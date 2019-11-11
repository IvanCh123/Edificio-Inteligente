import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DomoticaTest{
	
	
	Mediator mediator; 
		
	List<Sensor> sensores; 
	List<Actuador> actuadores; 
	
	@Before
	public void init(){
		mediator = new Mediator(); 
		sensores = new ArrayList<Sensor>(); 
		actuadores = new ArrayList<Actuador>(); 
	}
	
	@Test
	public void hayMovimientoEncenderBombilloTest(){
		
		Sensor movimiento = new Movimiento(); 
		
		Actuador bombillo = new Bombillo(); 
		Actuador aire = new AireAcondicionado(); 
		
		movimiento.setMediator(mediator);
		bombillo.setMediator(mediator);
		aire.setMediator(mediator);		
		
		sensores.add(movimiento); 
		actuadores.add(bombillo); 
		actuadores.add(aire); 
		
		mediator.setActuadores(actuadores);
		mediator.setSensores(sensores);
		
		aire.encender();
		
		assertTrue("Aire encendido", aire.getEstado());
		
		mediator.addComportamiento("Hay Movimiento", new EncenderBombillo(bombillo));
		mediator.addComportamiento("Bombillo encender", new ApagarAire(aire));
		
		movimiento.setEstado(true); 
		
		
		assertTrue("Se encendió el bombillo",bombillo.getEstado());
		assertFalse("Se apago el aire",aire.getEstado());
	}
	
//	@Test 
	public void enciendeBombilloApagarRadioTest()
	{
		
	}
	
//	@Test
	public void temp31EncenderAC()
	{
		
	}
}
