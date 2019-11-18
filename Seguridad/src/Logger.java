
public class Logger implements ActividadListener {
	
	@Override
	public void update(String tipo, int id) {
		this.logs.add(tipo + " de inquilino: " + id + "\n");
	}
	
	@Override
	public String print() {
		String log = "";
		for(int i = 0; i < this.logs.size(); ++i) {
			log += this.logs.get(i);
		}
		return log;
	}

}
