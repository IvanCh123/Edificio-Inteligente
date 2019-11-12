import java.util.ArrayList; 
import java.util.List;
import java.io.Serializable;

public class Caja implements Serializable{
	
	private static Caja INSTANCE;
	
	
	private Orden orden;
	private List<Orden> ordenes; 
	
	
	private Caja()
	{
		this.ordenes = new ArrayList<Orden>();
	}
	
	public void addOrden(Orden sandwiches) 
	{
		this.ordenes.add(sandwiches);
	}
	
	public void generarInforme(Orden orden){
		System.out.println("Generando informe...");
		System.out.println(this.orden.generarInforme(orden));
	}

	
	public List<Orden> getState()
	{
	      return ordenes;
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
