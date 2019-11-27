

public class SensorTemperatura extends Sensor{
	
	float temperatura;
	
	protected Sensor crearSensor() 
	{
		return new SensorTemperatura();
	}
	
	public SensorTemperatura()
	{
		this.tipoSensor = "Temperatura"; 
	}
	
	public void setTemperatura(float temperatura) {
		
		if(this.temperatura != 0) 
		{
			if(temperatura > this.temperatura)
			{
				System.out.println("\nTemperatura aument�: "+temperatura);
				this.notify(("Temperatura mayor").toLowerCase() );
				
			}else if(temperatura < this.temperatura)
			{
				System.out.println("\nTemperatura disminuy�: "+temperatura);
				this.notify(("Temperatura menor").toLowerCase() );
			}else 
			{
				System.out.println("\nTemperatura se mantuvo");
				this.notify(("Temperatura igual").toLowerCase() );
			}
		}
		else 
		{
			this.temperatura = temperatura;
			System.out.println("\nTemperatura inicial: "+this.temperatura);
		}
		
	} 
	
	public float getTemperatura() {
		return this.temperatura;
	}
}
