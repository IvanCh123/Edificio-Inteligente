
public class Logger implements ActividadListener {

	String log;
	
	public Logger() {
		log = "";
	}
	
	@Override
	public void update(String evento, int id) {
		this.log.concat(evento);
		this.log.concat(" de inquilino: ".concat(Integer.toString(id)));
		this.log.concat("\n");
	}

}
