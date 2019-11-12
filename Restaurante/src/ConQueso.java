
public class ConQueso implements Sandwich {

	private Sandwich sandwich;
	
	private double queso = 0.75;
	
	public ConQueso(Sandwich sandwich) {
		this.sandwich = sandwich;
	}
	
	@Override
	public String descripcion() 
	{
		return this.sandwich.descripcion()+" con queso";
	}

	@Override
	public double precioSandwich() 
	{
		return this.sandwich.precioSandwich()+queso;
	}

}
