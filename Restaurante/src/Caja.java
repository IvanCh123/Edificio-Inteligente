import java.util.ArrayList; 
import java.util.List;


public class Caja {
	
	List<Sandwich> sandiwches; 
	
	public static class Memento	{
		
		private final List<Sandwich> estado; 
		
		private Memento(List<Sandwich> estado)
		{
			this.estado = new ArrayList<Sandwich>(estado.size());
			for( Sandwich each : estado)
			{
				if( each instanceof SandwichMexicano)
				{
					Sandwich sandwich;
					sandwich = new SandwichMexicano();
					this.estado.add(sandwich);
				}
				else if (each instanceof SandwichItaliano)
				{
					Sandwich sandwich;
					sandwich = new SandwichItaliano();
					this.estado.add(sandwich);
				}
			}
		}
		
	}
	
}
