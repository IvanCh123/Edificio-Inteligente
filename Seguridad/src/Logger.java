
public class Logger implements ActividadListener {

	String log;
	
	public Logger() {
		log = "";
	}
	
	@Override
	public void update(String tipo, int id) {
		this.log.concat(tipo);
		this.log.concat(" de inquilino: ".concat(Integer.toString(id)));
		this.log.concat("\n");
	}

}
