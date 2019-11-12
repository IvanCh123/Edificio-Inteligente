import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class RestauranteTester {

	List<Sandwich> sandwiches;
	Caja caja;
	
	@Before
	public void init()
	{
		this.sandwiches = new ArrayList<Sandwich>();
		this.caja = new Caja();
	}
	
	@Test
	public void mexicanoConTomate()
	{
		Sandwich conTomate = new SandwichMexicano(new ConTomate());
		
		sandwiches.add(conTomate);
		
		Orden orden = new Orden(this.sandwiches);
		
		this.caja.addOrden(orden);
		this.caja.generarInforme(orden);
		
		assertEquals("Sandwich Mexicano con tomate",caja.generarInforme(orden));
	}
	
	@Test
	public void mexicanoConQueso()
	{
		Sandwich conQueso = new SandwichMexicano(new ConQueso());
		
		this.sandwiches.add(conQueso);
		
		Orden orden = new Orden(this.sandwiches);
		
		this.caja.addOrden(orden);
		this.caja.generarInforme(orden);
		
		assertEquals("Sandwich Mexicano con queso",caja.generarInforme(orden));
	}
	
	@Test
	public void italianoConTomate()
	{
		Sandwich conTomate = new SandwichItaliano(new ConTomate());
		
		sandwiches.add(conTomate);
		
		Orden orden = new Orden(this.sandwiches);
		
		this.caja.addOrden(orden);
		this.caja.generarInforme(orden);
		
		assertEquals("Sandwich Mexicano con tomate",caja.generarInforme(orden));
	}
	
	@Test
	public void italianoConQueso()
	{
		Sandwich conQueso = new SandwichItaliano(new ConQueso());
		
		this.sandwiches.add(conQueso);
		
		Orden orden = new Orden(this.sandwiches);
		
		this.caja.addOrden(orden);
		this.caja.generarInforme(orden);
		
		assertEquals("Sandwich Italiano con queso",caja.generarInforme(orden));
	}

}
