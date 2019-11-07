import java.util.HashMap;
import java.util.ArrayList;

public class InternetManager implements InternetInterface{
	HashMap <Integer,ArrayList<String>> registros;
	public InternetManager() {
		this.registros = new HashMap<Integer,ArrayList<String>>();
	}

	@Override
	public String acceder(int idRegistro, String pagina) {
		this.registros.get(idRegistro).add(pagina);
		return ("Se accedió a la página "+pagina);
	}

	public void verificar(int id) {
		if(!this.registros.containsKey(id)) {
			this.registros.put(id, new ArrayList<String>());
		}
	}
}
