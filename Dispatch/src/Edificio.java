import java.util.List; 
import java.util.ArrayList;

public class Edificio {

	private int numeroDePisos; 
	private List<Elevador> elevadores; 
	
	private Edificio() {
		elevadores = new ArrayList<Elevador>(); 
	}
	
	public static class Builder
	{
		private Edificio edificio; 
		
		public Builder()
		{
			edificio = new Edificio(); 
		}
		
		public Builder setNumeroDePisos(int numeroDePisos)
		{
			edificio.numeroDePisos = numeroDePisos; 
			return this; 
		}
		
		public Builder setElevadores(List<Elevador> elevadores)
		{
			edificio.elevadores.addAll(elevadores); 
			return this; 
		}
		
		public Edificio crea()
		{
			return edificio; 
		}
	}
}
