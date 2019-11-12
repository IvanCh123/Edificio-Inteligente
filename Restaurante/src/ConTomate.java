
public class ConTomate implements Sandwich {

	private Sandwich sandwich;
	
	private double tomate = 0.5;
	
	public ConTomate(Sandwich sandwich) 
	{
		this.sandwich = sandwich;
	}
	
	@Override
	public String descripcion() 
	{
		return this.sandwich.descripcion()+" con tomate";
	}

	@Override
	public double precioSandwich() 
	{
		return this.sandwich.precioSandwich()+tomate;
	}

}
