import java.util.ArrayList;
import java.util.List;

import java.time.LocalDateTime; // Import the LocalDateTime class
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class


public class Orden {
	
	private List<Sandwich> orden; 
	private double total;
	
	DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	
	public Orden()
	{
		this.orden = new ArrayList<Sandwich>();
		this.total = 0.0;
	}
	
	public List<Sandwich> getOrden(){
		return this.orden;
	}
	
	
	public void addSandwich(Sandwich sandwich){
		this.orden.add(sandwich);
	}
	
	public double getTotal(){
		return this.total;
	}
	
	public String generarInforme(Orden orden){
		String informe = "";
		String time = LocalDateTime.now().format(this.timeFormat);
		
		informe+="\n------------------"
				+ "\nProducto(s):";
				
		for(Sandwich each : orden.getOrden()) {
			informe+= "\n	Sandwich: "+each.descripcion()
					 +"\n	Precio: "+each.precioSandwich()+"\n";
			this.total+=each.precioSandwich();	
		}
				
		informe+="\nTotal: $"+this.total	
				 +"\nHora: "+time
				 +"\n------------------";
		return informe;
	}
	
	public Memento backUp()
	{
		System.out.println("Guardando en el Memento");
		return new Memento(this.orden, this.total);
	}
	
	public void restore(Memento memento)
	{
		System.out.println("Restaurando Memento");
		this.orden = memento.getState();
		this.total = memento.getTotal();
	}	
	
	public static class Memento	{	
		private final List<Sandwich> estado; 
		private final double total;
		
		private Memento(List<Sandwich> listaSandwich, double total)
		{
			this.estado = new ArrayList<Sandwich>();
			this.total = total;
			for( Sandwich each : listaSandwich)
			{				
				this.estado.add(each);
			}
		}
		
		public List<Sandwich> getState()
		{
			return this.estado;
		}
		
		public double getTotal(){
			return this.total;
		}
	}
}
