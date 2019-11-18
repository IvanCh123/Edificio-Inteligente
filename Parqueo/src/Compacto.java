
public class Compacto implements Vehiculo {
	
	@Override
	public String getTamano() {
		return "Mediano";
	}

	@Override
	public Vehiculo crearVehiculo() {
		return new Compacto();
	}

}
