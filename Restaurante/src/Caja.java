import java.util.ArrayList; 
import java.util.List;
import java.io.Serializable;

public class Caja implements Serializable{
	
	private static Caja INSTANCE;
	private List<Sandwich> sandiwches; 
	
	
	private Caja()
	{
		this.sandiwches = new ArrayList<Sandwich>();
	}
	
	public void setState(List<Sandwich> sandwich)
	{
		this.sandiwches = sandwich;
	}
	
	public List<Sandwich> getState()
	{
	      return sandiwches;
	}
	
	public Memento backUp()
	{
		return new Memento(this.sandiwches);
	}
	
	public void restore(Memento memento)
	{
		this.sandiwches = memento.getState();
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

	
	public synchronized static Caja getCaja()
	{
		if(INSTANCE == null)
			INSTANCE = new Caja();
		return INSTANCE;
	}
	
	private Object readResolve()
	{
		return INSTANCE;
	}
	
	private static final long serialVersionUID = 1L; // No entiendo, ocupo explicación
}
