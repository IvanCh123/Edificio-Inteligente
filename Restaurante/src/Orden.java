import java.util.ArrayList;
import java.util.List;

public class Orden {
	
	private List<Sandwich> orden; 
	
	public Orden(List<Sandwich> sandwiches)
	{
		this.orden = sandwiches;
	}
	
	public List<Sandwich> getOrden(){
		return this.orden;
	}
	
	public String generarInforme(Orden orden){
		String informe = "";
		for(Sandwich each : orden.getOrden()) {
			informe+="\n------------------\n"
					 +"\nSandwich: "+each.descripcion()
					 +"\nPrecio: "+each.precioSandwich()
					 +"\n------------------\n";
		}
		return informe;
	}
	
	public Memento backUp()
	{
		return new Memento(this.orden);
	}
	
	public void restore(Memento memento)
	{
		this.orden = memento.getState();
	}
	
	public static class Memento	{	
		private final List<Sandwich> estado; 
		
		private Memento(List<Sandwich> listaSandwich)
		{
			this.estado = new ArrayList<Sandwich>(listaSandwich.size());
			for( Sandwich each : estado)
			{
				Sandwich sandwich = null;
				if( each instanceof SandwichMexicano)
				{
					sandwich = new SandwichMexicano();		
				}
				else if (each instanceof SandwichItaliano)
				{
					sandwich = new SandwichItaliano();
				}
				
				this.estado.add(sandwich);
			}
		}
		
		public List<Sandwich> getState()
		{
			return this.estado;
		}
	}
}
