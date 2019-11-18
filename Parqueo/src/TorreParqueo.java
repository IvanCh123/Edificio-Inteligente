
public class TorreParqueo {
	int pequeno;
	int mediano;
	int grande;
	int pequenoDisponible;
	int medianoDisponible;
	int grandeDisponible;
	
	public TorreParqueo(int cantidadParqueos, int accesos) {
		pequeno = (int) (cantidadParqueos*0.25);
		grande = (int) (cantidadParqueos*0.25);
		mediano = cantidadParqueos-(pequeno+grande);
		pequenoDisponible = 0;
		medianoDisponible = 0;
		grandeDisponible = 0;
	}
	
	public void parquear(Vehiculo vehiculo) {
		String tamano = vehiculo.getTamano();
		System.out.println("Iniciando proceso de parqueo para vehículo: " + tamano + "\n");
	}
}
