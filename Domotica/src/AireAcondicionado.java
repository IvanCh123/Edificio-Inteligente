

public class AireAcondicionado extends Actuador{
	
	int potencia;
	
	protected Actuador crearActuador() 
	{
		return new AireAcondicionado(); 
	}
	
	public AireAcondicionado()
	{
		this.tipoActuador = "Aire acondicionado";
	}
	
	
	public void setPotencia(int potencia) {
		
		if(this.potencia != 0) 
		{
			if(potencia > this.potencia)
			{
				System.out.println("\nVelocidad aire aumentó: "+potencia);
				this.notify(("Potencia Aire mayor").toLowerCase() );
				
			}else if(potencia < this.potencia)
			{
				System.out.println("\nVelocidad aire disminuyó: "+potencia);
				this.notify(("Potencia Aire menor").toLowerCase() );
			}else 
			{
				System.out.println("\nVelocidad aire se mantuvo");
				this.notify(("Potencia Aire igual").toLowerCase() );
			}
		}
		else 
		{
			this.potencia = potencia;
			System.out.println("\nPotencia aire inicial: "+this.potencia);
		}
	}
	
	public int getPotencia() 
	{
		return this.potencia; 
	} 
	

}
