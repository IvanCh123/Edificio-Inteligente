
public class Motocicleta extends Vehiculo {
	
	protected Vehiculo crearVehiculo() {
		return new Motocicleta();
	}
	
	
	public String getTamano() {
		return "Pequeño";
	}
}
