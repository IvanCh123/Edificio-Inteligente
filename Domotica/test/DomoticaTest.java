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
	public void hayMovimientoEncenderBombilloApagarAire()
	{	
		System.out.println("\n\n===== hayMovimientoEncenderBombilloApagarAire =====");
		
		ActuadoresFactory bombilloFactory = new BombilloFactory();
		Actuador bombillo = bombilloFactory.crear(); 
		ActuadoresFactory aireFactory = new AireAcondicionadoFactory();
		Actuador aire = aireFactory.crear();
		
		Sensor movimiento = new SensorMovimiento();
		
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
		
		
		assertTrue("Se encendio el bombillo",bombillo.getEstado());
		assertFalse("Se apago el aire",aire.getEstado());
	}
	
	@Test 
	public void enciendeBombilloApagarRadio()
	{
		System.out.println("\n\n===== enciendeBombilloApagarRadio =====");
		
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
		System.out.println("\n\n===== encenderTeleCambiarColorBombillo =====");
		
		ActuadoresFactory bombilloFactory = new BombilloFactory();
		Actuador bombillo = bombilloFactory.crear();
		
		ActuadoresFactory teleFactory = new TelevisionFactory();
		Actuador television = teleFactory.crear();
		
		bombillo.setMediator(this.mediator);
		television.setMediator(this.mediator);
		
		this.actuadores.add(bombillo);
		this.actuadores.add(television);
		
		this.mediator.setActuadores(this.actuadores);
		
		this.mediator.addComportamiento("TeLevIsiOn encender", new CambiarColorBombillo( bombillo, "rojo"));
		
		television.encender();
		
		assertEquals("rojo",((Bombillo)bombillo).getColor());
	}
	
	@Test
	public void encenderBombilloSalaApagaBombilloCocina() 
	{
		System.out.println("\n\n===== encenderBombilloSalaApagaBombilloCocina =====");
		
		
		ActuadoresFactory bombilloFactory = new BombilloFactory();
		Actuador bombilloSala = bombilloFactory.crear();
		Actuador bombilloCocina = bombilloFactory.crear();
		
		bombilloSala.setMediator(this.mediator);
		bombilloCocina.setMediator(this.mediator);
		
		bombilloSala.setTipoActuador("Bombillo sala");
		bombilloCocina.setTipoActuador("Bombillo cocina");
		
		
		this.actuadores.add(bombilloSala);
		this.actuadores.add(bombilloCocina);
		this.mediator.setActuadores(this.actuadores);
		
		
		
		this.mediator.addComportamiento("Bombillo sala encender", new ApagarBombillo(bombilloCocina));
		
		bombilloSala.encender();
		
		
		assertFalse("Se apago bombillo sala",bombilloCocina.getEstado());
		
	}
	
	@Test
	public void sensorTemperaturaMenorEncenderAire()
	{
		
		System.out.println("\n\n===== sensorTemperaturaMenorEncenderAire =====");
		
		ActuadoresFactory aireFactory = new AireAcondicionadoFactory();
		Actuador aire = aireFactory.crear();
		
		Sensor temperatura = new SensorTemperatura();
		
		aire.setMediator(this.mediator);
		temperatura.setMediator(this.mediator);
		
		this.actuadores.add(aire);
		this.sensores.add(temperatura);
		
		this.mediator.setActuadores(this.actuadores);
		this.mediator.setSensores(this.sensores);
		
		
		((SensorTemperatura)temperatura).setTemperatura(21);
		
		this.mediator.addComportamiento("TempERatura menor", new EncenderAire(aire));
		
		((SensorTemperatura)temperatura).setTemperatura(14);
		
		assertTrue("Se encendio el aire",aire.getEstado());
		
		
	}
}
