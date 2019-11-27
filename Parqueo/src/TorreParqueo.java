
public class TorreParqueo {
	int pequeno;
	int mediano;
	int grande;
	int pequenoDisponible;
	int medianoDisponible;
	int grandeDisponible;
	
	public TorreParqueo(int cantidadParqueos, int accesos, int pisos) {
		pequeno = (int) (cantidadParqueos*0.25);
		grande = (int) (cantidadParqueos*0.25);
		mediano = cantidadParqueos-(pequeno+grande);
		pequenoDisponible = 0;
		medianoDisponible = 0;
		grandeDisponible = 0;
	}
	
	public String parquear(Vehiculo vehiculo) {
		String ficha = "";
		String tamano = vehiculo.getTamano();
		System.out.println("Iniciando proceso de parqueo para vehículo: " + tamano + "\n");
		// - Hacer matriz de pisos con lugares de parqueos para armar la ficha
		// - Búsqueda recursiva de espacio más cercano al acceso
		// - Clase Acceso que tenga espacio más cercano disponible
		// - Patrón Observer entre los accesos para notificar cuando se utiliza un acceso
		// para que si el que se usa es el más cercano del otro entonces este tiene que buscar uno nuevo
		return ficha;
	}
	
	public Vehiculo retirarVehiculo(String ficha) {
		Vehiculo vehiculo = new Sedan();
		int posicion;
		return vehiculo;
	}
}
