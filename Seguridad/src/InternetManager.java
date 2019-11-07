import java.util.ArrayList;

public class InternetManager implements InternetInterface{
	ArrayList<ArrayList<String>> registros;

	public InternetManager() {
		this.registros = new ArrayList<ArrayList<String>>();
	}

	@Override
	public void acceder(int idRegistro, String pagina) {	
		this.registros.get(idRegistro).add(pagina);
		System.out.print("Se accedió a la página "+pagina);
	}

}
