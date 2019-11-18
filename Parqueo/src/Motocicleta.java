
public class Motocicleta implements Vehiculo {
	
	@Override
	public String getTamano() {
		return "Pequeño";
	}

	@Override
	public Vehiculo crearVehiculo() {
		return new Motocicleta();
	}


}
