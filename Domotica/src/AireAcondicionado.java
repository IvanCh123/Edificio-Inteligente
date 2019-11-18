

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
		this.potencia = potencia; 
	}
	
	public int getPotencia() {
		return this.potencia; 
	}
	

}
