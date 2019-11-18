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
		
		Sensor movimiento = new SensorMovimiento(); 
		
		Actuador bombillo = new Bombillo(); 
		Actuador aire = new AireAcondicionado(); 
		
		movimiento.setMediator(this.mediator);
		bombillo.setMediator(this.mediator);
		aire.setMediator(this.mediator);		
		
		this.sensores.add(movimiento); 
		this.actuadores.add(bombillo); 
		this.actuadores.add(aire); 
		
		this.mediator.setActuadores(this.actuadores);
		this.mediator.setSensores(this.sensores);
		
		aire.encender();
		
		assertTrue("Aire encendido", aire.getEstado());
		
		
		this.mediator.addComportamiento("Hay Movimiento", new EncenderBombillo(bombillo));
		this.mediator.addComportamiento("Bombillo encender", new ApagarAire(aire));
		
		movimiento.setEstado(true); 
		
		
		assertTrue("Se encendió el bombillo",bombillo.getEstado());
		assertFalse("Se apago el aire",aire.getEstado());
	}
	
	@Test 
	public void enciendeBombilloApagarRadioTest()
	{
		ActuadoresFactory bombilloFactory = new BombilloFactory();
		Actuador bombillo = bombilloFactory.crear();
		
		ActuadoresFactory radioFactory = new RadioFactory();
		Actuador radio = radioFactory.crear();
		
		bombillo.setMediator(this.mediator);
		radio.setMediator(this.mediator);
		
		this.actuadores.add(bombillo);
		this.actuadores.add(radio);
		
		this.mediator.setActuadores(this.actuadores);
		
		this.mediator.addComportamiento("Bombillo encender", new ApagarRadio(radio));
		bombillo.encender();
		
		assertFalse("Se apagó el radio",radio.getEstado());		
	}
	
	@Test
	public void encenderTeleCambiarColorBombillo()
	{
		ActuadoresFactory bombilloFactory = new BombilloFactory();
		Actuador bombillo = bombilloFactory.crear();
		
		ActuadoresFactory teleFactory = new TelevisionFactory();
		Actuador television = teleFactory.crear();
		
		bombillo.setMediator(this.mediator);
		television.setMediator(this.mediator);
		
		this.mediator.setActuadores(this.actuadores);
		
		this.mediator.addComportamiento("Television encender", new CambiarColorBombillo( bombillo, "rojo"));
		
		television.encender();
		
		System.out.println("Estado: "+((Bombillo)bombillo).getColor());
		assertEquals("rojo",((Bombillo)bombillo).getColor());
	}
}
