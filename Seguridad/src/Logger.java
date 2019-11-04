
public class Logger implements ActividadListener {

	String log;
	
	public Logger() {
		log = "";
	}
	
	@Override
	public void update(String tipo, int id) {
		this.log += tipo + " de inquilino: " + id + "\n";
	}
	
	@Override
	public String print() {
		return this.log;
	}

}
