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
	
<<<<<<< HEAD
	public String generarInforme(Orden orden){
=======
	public void enviarOrdenesAlChef()
	{
		System.out.println("Enviando la orden al chef\n");
	}
	
	public void cobrarAlCliente()
	{
		System.out.println("Cobrando al cliente\n");
	}
	
	public void generarInforme(Orden orden){
>>>>>>> fb437ed1c28fe3a42acfa6fd09e08dce69b9ceb4
		System.out.println("Generando informe...");
		return (this.orden.generarInforme(orden));
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
	
	private static final long serialVersionUID = 1L; // No entiendo, ocupo explicaci�n
}
