import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.*;

class RestauranteTester {

	List<Sandwich> sandwiches;
	Caja caja;
	
	@BeforeEach
	public void init()
	{
		this.sandwiches = new ArrayList<Sandwich>();
		this.caja = Caja.getCaja();
	}
	
	@Test
	public void mexicanoConTomate()
	{
		Sandwich conTomate = new ConTomate(new SandwichMexicano());
		
		sandwiches.add(conTomate);
		
		Orden orden = new Orden(this.sandwiches);
		
		this.caja.addOrden(orden);
		this.caja.generarInforme(orden);
		
		assertEquals("Sandwich Mexicano con tomate",conTomate.descripcion());
	}
	
	@Test
	public void mexicanoConQueso()
	{
		Sandwich conQueso = new ConQueso(new SandwichMexicano());
		
		this.sandwiches.add(conQueso);
		
		Orden orden = new Orden(this.sandwiches);
		
		this.caja.addOrden(orden);
		this.caja.generarInforme(orden);
		
		assertEquals("Sandwich Mexicano con queso",conQueso.descripcion());
	}
	
	@Test
	public void italianoConTomate()
	{
		Sandwich conTomate = new ConTomate(new SandwichItaliano());
		
		sandwiches.add(conTomate);
		
		Orden orden = new Orden(this.sandwiches);
		
		this.caja.addOrden(orden);
		this.caja.generarInforme(orden);
		
		assertEquals("Sandwich Italiano con tomate",conTomate.descripcion());
	}
	
	@Test
	public void italianoConQueso()
	{
		Sandwich conQueso = new ConQueso(new SandwichItaliano());
		
		this.sandwiches.add(conQueso);
		
		Orden orden = new Orden(this.sandwiches);
		
		this.caja.addOrden(orden);
		this.caja.generarInforme(orden);
		
		assertEquals("Sandwich Italiano con queso",conQueso.descripcion());
	}

}
