public class SandwichItaliano implements Sandwich {
	
	@Override
	public String descripcion() 
	{
		return "Sandwich Italiano";
	}
	
	@Override
	public double precioSandwich()
	{
		return 6;
	}
	
	@Override
	public String getTipo(){
		return "Italiano";
	}
}
