
public class Sedan extends Vehiculo {
	
	protected Vehiculo crearVehiculo() {
		return new Sedan();
	}
	
	public String getTamano() {
		return "Mediano";
	}
}
