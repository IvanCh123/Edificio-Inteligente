
public class AireAcondicionado {
	
	int potencia;
	boolean estado;
	
	public AireAcondicionado(int potencia)
	{
		this.potencia = potencia; 
	}
	
	public void encender(){
		this.estado = true; 
	}
	
	public void apagar() {
		this.estado = false; 
	}
	
	public void setPotencia(int potencia) {
		this.potencia = potencia; 
	}
	
	public int getPotencia() {
		return this.potencia; 
	}
	
	public boolean getEstado() {
		return this.estado;
	}
	
	
}
