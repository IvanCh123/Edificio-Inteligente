
public class SUV implements Vehiculo {

	@Override
	public String getTamano() {
		return "Grande";
	}

	@Override
	public Vehiculo crearVehiculo() {
		return new SUV();
	}

}
