
public abstract class VehiculosFactory {

	public Vehiculo crear() {
		Vehiculo vehiculo = crearVehiculo();
		return vehiculo;
	}
	
	protected abstract Vehiculo crearVehiculo();
}
