import java.util.ArrayList;

public class TorreParqueo {
	int pequeno;
	int mediano;
	int grande;
	int pequenoDisponible;
	int medianoDisponible;
	int grandeDisponible;
	private int cantidadPisos;
	private int cantidadEspacios;
	private int cantidadEspaciosPiso;
	private Vehiculo espaciosParqueo[][];
	
	public TorreParqueo(int cantidadParqueos, int accesos, int pisos) {
		pequeno = (int) (cantidadParqueos*0.25);
		grande = (int) (cantidadParqueos*0.25);
		mediano = cantidadParqueos-(pequeno+grande);
		pequenoDisponible = 0;
		medianoDisponible = 0;
		grandeDisponible = 0;
		this.setCantidadEspacios(cantidadParqueos);
		this.setCantidadPisos(pisos);
		this.setCantidadEspaciosPiso(cantidadParqueos, pisos);
		this.espaciosParqueo = new Vehiculo[pisos][this.cantidadEspaciosPiso];
	}
	
	public String parquear(Vehiculo vehiculo) {
		String ficha = "";
		String tamano = vehiculo.getTamano();
		System.out.println("Iniciando proceso de parqueo para vehículo: " + tamano + "\n");
		for (int i = 0; i < this.getCantidadPisos(); i++) {
			for (int j = 0; j < this.getCantidadEspaciosPiso(); j++) {
				if (this.espaciosParqueo[i][j] == null) {
					this.espaciosParqueo[i][j] = vehiculo;
					ficha = i+"-"+j;
				}
			}
		}		
		// - Hacer matriz de pisos con lugares de parqueos para armar la ficha
		// - Búsqueda recursiva de espacio más cercano al acceso
		// - Clase Acceso que tenga espacio más cercano disponible
		// - Patrón Observer entre los accesos para notificar cuando se utiliza un acceso
		// para que si el que se usa es el más cercano del otro entonces este tiene que buscar uno nuevo
		System.out.println("Su vehiculo ha sido parqueado. Su ficha es: "+ficha);
		return ficha;
	}
	
	public Vehiculo retirarVehiculo(String ficha) {
		String[] ubicacion = ficha.split("-");
		int piso = Integer.parseInt(ubicacion[0]);
		int campo = Integer.parseInt(ubicacion[1]);
		Vehiculo vehiculo = null;
		if(this.espaciosParqueo[piso][campo] != null) {
			vehiculo = this.espaciosParqueo[piso][campo];
			this.espaciosParqueo[piso][campo] = null;
		}else {
			System.out.println("La ficha que entregó no es válida, por favor intentelo de nuevo");
		}
		return vehiculo;
	}
	
	public void setCantidadEspacios(int espacios) {
		this.cantidadEspacios = espacios;
	}
	
	public int getCantidadEspacios() {
		return this.cantidadEspacios;
	}
	
	public void setCantidadPisos(int pisos) {
		this.cantidadPisos = pisos;
	}
	
	public int getCantidadPisos() {
		return this.cantidadPisos;
	}

	public int calcularCantidadEspaciosPiso(int cantidadTotal, int pisos) {
		return (int)Math.ceil(cantidadTotal/pisos);
	}
	
	public int getCantidadEspaciosPiso() {
		return cantidadEspaciosPiso;
	}

	public void setCantidadEspaciosPiso(int cantidadTotal, int pisos) {
		this.cantidadEspaciosPiso = this.calcularCantidadEspaciosPiso(cantidadTotal, pisos);
	}
}
