import java.util.ArrayList;
import java.util.List;

import java.time.LocalDateTime; // Import the LocalDateTime class
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class


public class Orden {
	
	private List<Sandwich> orden; 
	
	DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	
	public Orden(List<Sandwich> sandwiches)
	{
		this.orden = sandwiches;
	}
	
	public List<Sandwich> getOrden(){
		return this.orden;
	}
	
	public String generarInforme(Orden orden){
		String informe = "";
		double total = 0.0;
		String time = LocalDateTime.now().format(this.timeFormat);
		
		informe+="\n------------------"
				+ "\nProducto(s):";
				
		for(Sandwich each : orden.getOrden()) {
			informe+= "\n	Sandwich: "+each.descripcion()
					 +"\n	Precio: "+each.precioSandwich()+"\n";
			total+=each.precioSandwich();	
		}
				
		informe+="\nTotal: $"+total	
				 +"\nHora: "+time
				 +"\n------------------";
		return informe;
	}
	
	public Memento backUp()
	{
		System.out.println("Guardando en el Memento");
		return new Memento(this.orden);
	}
	
	public void restore(Memento memento)
	{
		System.out.println("Restaurando Memento");
		this.orden = memento.getState();
	}
	
	
	public static class Memento	{	
		private final List<Sandwich> estado; 
		
		private Memento(List<Sandwich> listaSandwich)
		{
			this.estado = new ArrayList<Sandwich>(listaSandwich.size());
			for( Sandwich each : this.estado)
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
