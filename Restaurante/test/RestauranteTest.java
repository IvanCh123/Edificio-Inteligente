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
	public void sandwichMexicano()
	{
		Sandwich conTomate = new ConTomate(new SandwichMexicano());
		Sandwich conQueso = new ConQueso(new SandwichMexicano());
		
		this.sandwiches.add(conTomate);
		this.sandwiches.add(conQueso);
		
		Orden orden = new Orden(this.sandwiches);
		
		this.caja.addOrden(orden);
		this.caja.generarInforme(orden);
		
		assertEquals("Sandwich Mexicano con tomate",conTomate.descripcion());
		assertEquals("Sandwich Mexicano con queso",conQueso.descripcion());
	}
	
	@Test
	public void sandwichItaliano()
	{
		Sandwich conTomate = new ConTomate(new SandwichItaliano());
		Sandwich conQueso = new ConQueso(new SandwichItaliano());
		
		sandwiches.add(conTomate);
		this.sandwiches.add(conQueso);
		
		Orden orden = new Orden(this.sandwiches);
		
		this.caja.addOrden(orden);
		this.caja.generarInforme(orden);
		
		assertEquals("Sandwich Italiano con tomate",conTomate.descripcion());
		assertEquals("Sandwich Italiano con queso",conQueso.descripcion());
	}
}
