
public class BombilloEnciende implements TratamientoComportamiento {

	Bombillo bombillo; 
	
	public BombilloEnciende(Bombillo bombillo)
	{
		this.bombillo = bombillo;
	}
	
	@Override
	public void ejecutar() {
		
		this.bombillo.encender();
	}

}
