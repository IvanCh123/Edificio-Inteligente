
public class SUV extends Vehiculo {

	@Override
	public String getTamano() {
		return "Grande";
	}

	@Override
	public Vehiculo crearVehiculo() {
		return new SUV();
	}

}
