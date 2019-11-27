import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RestauranteTest {
	
	Caja caja;
	Orden orden;
	
	@Before
	public void init()
	{
		this.caja = Caja.getCaja();
		this.orden = new Orden();
	}
	
	@Test
	public void sandwichMexicano()
	{
		Sandwich conTomate = new ConTomate(new SandwichMexicano());
		Sandwich conQueso = new ConQueso(new SandwichMexicano());
		
		this.orden.addSandwich(conTomate);
		this.orden.addSandwich(conQueso);
				
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
		
		this.orden.addSandwich(conTomate);
		this.orden.addSandwich(conQueso);
		
		this.caja.addOrden(orden);
		this.caja.generarInforme(orden);
		
		assertEquals("Sandwich Italiano con tomate",conTomate.descripcion());
		assertEquals("Sandwich Italiano con queso",conQueso.descripcion());
	}
	
	@Test
	public void testMemento(){
		Sandwich conTomate = new ConTomate(new SandwichItaliano());
		Sandwich conQueso = new ConQueso(new SandwichItaliano());
		Sandwich conQuesoQueso = new ConQueso(new ConQueso(new SandwichItaliano()));
		
		this.orden.addSandwich(conTomate);
		this.orden.addSandwich(conQueso);
		
		this.orden.addSandwich(conQuesoQueso);
		
		this.caja.generarInforme(orden);
		
		this.orden.restore();
		
		this.caja.addOrden(orden);
		this.caja.generarInforme(orden);
		
		assertEquals("13.25",this.caja.getTotal(orden));
		
		
	}
}
