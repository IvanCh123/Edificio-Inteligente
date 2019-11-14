public class SandwichMexicano implements Sandwich {

	@Override
	public String descripcion() 
	{
		return "Sandwich Mexicano";	
	}

	@Override
	public double precioSandwich()
	{
		return 5;
	}
	
	@Override
	public String getTipo(){
		return "Mexicano";
	}

}
